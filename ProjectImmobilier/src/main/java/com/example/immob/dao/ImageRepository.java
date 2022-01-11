package com.example.immob.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.immob.entities.Annonce;
import com.example.immob.entities.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	Optional<ImageModel> findByName(String name);
	
	@Query("select i from ImageModel i inner join i.annonce a where a.id = :id")
	public List<ImageModel> findImageModelsByAnnonceId(@Param("id") Long id);
}
