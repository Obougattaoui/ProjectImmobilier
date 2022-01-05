package com.example.immob.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	Optional<ImageModel> findByName(String name);
}
