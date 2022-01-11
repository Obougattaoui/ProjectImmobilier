package com.example.immob.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.immob.entities.ImageModel;

public interface ImageService {
	public void uploadImage(MultipartFile file) throws IOException;
	public ImageModel findImageByName(String imageName) throws IOException;
	public ImageModel findImageModelById(Long id) throws IOException;
	public List<ImageModel> findImageModelsByAnnonceId(Long id);
	public ImageModel updateImage(Long id, ImageModel image);
}
