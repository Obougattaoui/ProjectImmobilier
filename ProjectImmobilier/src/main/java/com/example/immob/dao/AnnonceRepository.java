package com.example.immob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.immob.entities.Annonce;
import com.example.immob.entities.AnnonceType;
import com.example.immob.entities.MaisonType;

public interface AnnonceRepository extends JpaRepository<Annonce, Long>{	
	public Annonce findByName(String name);
	public Annonce findByVille(String ville);
	public Annonce findByPrix(double prix);
	public Annonce findByAnnonceType(AnnonceType annonceType);
	public Annonce findByMaisonType(MaisonType maisonType);
	@Query("select a from Annonce a inner join a.utilisateur u where u.id = :id")
	public List<Annonce> findAnnoncesByUsers(@Param("id") Long id);
	@Query("SELECT COUNT(*) FROM Annonce a INNER JOIN a.utilisateur u where u.id=:id")
	public Long getCount(@Param("id") Long id);
}
