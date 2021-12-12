package com.example.immob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.Annonce;
import com.example.immob.entities.AnnonceType;
import com.example.immob.entities.MaisonType;

public interface AnnonceRepository extends JpaRepository<Annonce, Long>{
	public Annonce findByName(String name);
	public Annonce findByVille(String ville);
	public Annonce findByPrix(double prix);
	public Annonce findByAnnonceType(AnnonceType annonceType);
	public Annonce findByMaisonType(MaisonType maisonType);
}
