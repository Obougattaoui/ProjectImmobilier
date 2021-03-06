package com.example.immob.service;

import java.util.List;

import com.example.immob.entities.Annonce;
import com.example.immob.entities.AnnonceType;
import com.example.immob.entities.ImageModel;
import com.example.immob.entities.MaisonType;

public interface AnnonceService {
	//Ajouter une annonce :
	public Annonce saveAnnonce(Annonce annonce);
	//chercher une annonce :
	public Annonce findAnnonceById(Long id);
	//chercher par le type d'annonce -> vente ou location:
	public Annonce findAnnonceByAnnonceType(AnnonceType annonceType);
	//chercher une annonce par maison type  :
	public Annonce findAnnonceByMaisonType(MaisonType maisonType);
	//chercher une annonce par le nom de la ville :
	public Annonce findAnnonceByVille(String ville);
	//chercher une annonce par prix :
	public Annonce findAnnonceByPrix(double prix);
	//Afficher la liste de toutes les annonces :
	public List<Annonce> findAll();
	//supprimer une annonce :
	public void deteleAnnonce(Long id);
	//update Annonce :
	public Annonce updateAnnnonce(Long id, Annonce newAnnonce);
	
	public List<Annonce> findAnnonceByUserId(Long id);
	public List<ImageModel> findImageModelsByAnnonceId(Long id);
	public Long getCountByUserId(Long id);
	
}
