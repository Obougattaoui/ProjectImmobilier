package com.example.immob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.immob.entities.Annonce;
import com.example.immob.entities.AnnonceType;
import com.example.immob.entities.ImageModel;
import com.example.immob.entities.MaisonType;
import com.example.immob.service.AnnonceService;
/*
 * 
 * Ajouter une nouvelle Annonce
 * */
@RestController
@RequestMapping("/annonce/")
public class AnnonceController {
	@Autowired
	private AnnonceService annonceService;
	
	@PostMapping("")
	public ResponseEntity<Annonce> saveAnnonce(@RequestBody Annonce annonce) {
		Annonce ann = annonceService.saveAnnonce(annonce);
		return ResponseEntity.ok(ann);
	}
	@GetMapping("annonces")
	public List<Annonce> getAll(){
		return annonceService.findAll();
	}
	@GetMapping("{id}")
	public Annonce getAnnonceById(@PathVariable("id") Long id) {
		return annonceService.findAnnonceById(id);
	}
	@GetMapping("byVille/{ville}")
	public Annonce getAnnonceByVille(@PathVariable("ville") String ville) {
		return annonceService.findAnnonceByVille(ville);
	}
	@GetMapping("byPrix/{prix}")
	public Annonce getAnnonceByPrix(@PathVariable("prix") double prix) {
		return annonceService.findAnnonceByPrix(prix);
	}
	@GetMapping("byType/{type}")
	public Annonce getAnnonceByMaisonType(@PathVariable("type") MaisonType maisonType) {
		return annonceService.findAnnonceByMaisonType(maisonType);
	}
	@GetMapping("byAnnonceType/{annonceType}")
	public Annonce getAnnonceByType(@PathVariable("annonceType") AnnonceType annonceType) {
		return annonceService.findAnnonceByAnnonceType(annonceType);
	}
	@PutMapping("{id}")
	public Annonce updateAnnonce(@PathVariable("id") Long id, @RequestBody Annonce newAnnonce) {
		return annonceService.updateAnnnonce(id, newAnnonce);
	}
	@DeleteMapping("{id}")
	public void deleteAnnonce(@PathVariable("id") Long id) {
		annonceService.deteleAnnonce(id);
	}
	@GetMapping("users/{id}")
	public List<Annonce> getAnnoncesBuUsersId(@PathVariable("id") Long id){
		return annonceService.findAnnonceByUserId(id);
	}
	@GetMapping("{id}/images")
	public List<ImageModel> getImageModels(@PathVariable("id") Long id){
		return annonceService.findImageModelsByAnnonceId(id);
	}
	@GetMapping("count/{id}")
	public Long getCountByUsersId(@PathVariable("id") Long id) {
		return annonceService.getCountByUserId(id);
	}
}
