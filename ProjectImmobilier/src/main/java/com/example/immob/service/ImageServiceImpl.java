package com.example.immob.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.immob.dao.ImageRepository;
import com.example.immob.entities.ImageModel;
@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private AnnonceService annonceService;
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
		
	@Override
	public void uploadImage(MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
		imageRepository.save(img);
	}

	@Override
	public ImageModel findImageByName(String imageName) throws IOException{
		final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
		if (!retrievedImage.isPresent())
			throw new RuntimeException("cette image n'existe pas");
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

	@Override
	public ImageModel findImageModelById(Long id) throws IOException{
		final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		if (!retrievedImage.isPresent())
			throw new RuntimeException("cette image n'existe pas");
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

	@Override
	public List<ImageModel> findImageModelsByAnnonceId(Long id) {
		annonceService.findAnnonceById(id);
		return imageRepository.findImageModelsByAnnonceId(id);
	}

	@Override
	public ImageModel updateImage(Long id, ImageModel image) {
		final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		if (!retrievedImage.isPresent())
			throw new RuntimeException("cette image n'existe pas");
		image.setId(id);
		return imageRepository.save(image);
	}

}
