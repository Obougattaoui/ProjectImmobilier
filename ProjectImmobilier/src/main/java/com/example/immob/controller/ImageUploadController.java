package com.example.immob.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.immob.entities.ImageModel;
import com.example.immob.service.ImageService;

@RestController
@RequestMapping("/image/")
public class ImageUploadController {
	@Autowired
	private ImageService imageService;
	@PostMapping("upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		imageService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ImageModel getImageById(@PathVariable("id") Long id) throws IOException {
		return imageService.findImageModelById(id);
	}
	@GetMapping(path = { "get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		return imageService.findImageByName(imageName);
	}
	@GetMapping("byAnnonce/{id}")
	public List<ImageModel> findImageModelsByAnnonceId(@PathVariable("id") Long id){
		return imageService.findImageModelsByAnnonceId(id);
	}
	@PutMapping("{id}")
	public ImageModel updateImage(@PathVariable("id") Long id, @RequestBody ImageModel image) {
		return imageService.updateImage(id, image);
	}
	
}
