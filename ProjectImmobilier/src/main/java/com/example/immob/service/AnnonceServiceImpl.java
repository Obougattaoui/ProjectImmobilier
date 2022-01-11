package com.example.immob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immob.dao.AnnonceRepository;
import com.example.immob.dao.ImageRepository;
import com.example.immob.dao.UserRepository;
import com.example.immob.entities.Annonce;
import com.example.immob.entities.AnnonceType;
import com.example.immob.entities.ImageModel;
import com.example.immob.entities.MaisonType;

@Service
public class AnnonceServiceImpl implements AnnonceService{
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public Annonce saveAnnonce(Annonce annonce) {
		return annonceRepository.save(annonce);
	}
	
	@Override
	public Annonce findAnnonceById(Long id) {
		Optional<Annonce> annonce = annonceRepository.findById(id);
		if (!annonce.isPresent()) {
			throw new RuntimeException("pas d'annonce ayant comme id = " + id);
		}	
		return annonce.get();
	}

	@Override
	public Annonce findAnnonceByAnnonceType(AnnonceType annonceType) {
		Annonce annonce = annonceRepository.findByAnnonceType(annonceType);
		if (annonce == null) {
			throw new RuntimeException("il n'existe aucun annonce de type : " + annonceType);
		}
		return annonce;
	}

	@Override
	public Annonce findAnnonceByMaisonType(MaisonType maisonType) {
		Annonce annonce = annonceRepository.findByMaisonType(maisonType);
		if (annonce == null) {
			throw new RuntimeException("il n'existe aucun maison de type : " + maisonType);
		}
		return annonce;
	}

	@Override
	public Annonce findAnnonceByVille(String ville) {
		Annonce annonce = annonceRepository.findByVille(ville);
		if (annonce == null) {
			throw new RuntimeException("il n'existe aucun maison dans la ville : " + ville);
		}
		return annonce;
	}

	@Override
	public Annonce findAnnonceByPrix(double prix) {
		Annonce annonce = annonceRepository.findByPrix(prix);
		if (annonce == null) {
			throw new RuntimeException("il n'existe aucun maison avec le prix : " + prix);
		}
		return annonce;
	}

	@Override
	public List<Annonce> findAll() {
		return annonceRepository.findAll();
	}
	
	@Override
	public void deteleAnnonce(Long id) {
		if (!annonceRepository.existsById(id))
			throw new RuntimeException("cette annonce n'existe pas " + id);
		Annonce annonce = this.findAnnonceById(id);
		annonceRepository.delete(annonce);
	}
	@Override
	public Annonce updateAnnnonce(Long id, Annonce newAnnonce) {
		Optional<Annonce> annonceOptional = annonceRepository.findById(id);
		if (!annonceOptional.isPresent())
			throw new RuntimeException("cette annonce n'existe pas " + id);
		newAnnonce.setId(id);
		return annonceRepository.save(newAnnonce);
	}

	@Override
	public List<Annonce> findAnnonceByUserId(Long id) {
		if(!userRepository.existsById(id))
			throw new RuntimeException("cette user n'existe pas ayant comme id: " + id);
		return annonceRepository.findAnnoncesByUsers(id);
	}
	public List<ImageModel> findImageModelsByAnnonceId(Long id){
		if(!annonceRepository.existsById(id))
			throw new RuntimeException("cette annonce n'existe pas " + id);
		return imageRepository.findImageModelsByAnnonceId(id);
	}

	@Override
	public Long getCountByUserId(Long id) {
		if(!userRepository.existsById(id))
			throw new RuntimeException("cette user n'existe pas ayant comme id: " + id);
		return annonceRepository.getCount(id);
	}
	
}
