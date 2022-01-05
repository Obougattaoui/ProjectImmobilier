package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.Immobilier;

public interface ImmobilierRepository extends JpaRepository<Immobilier, Long>{
	public Immobilier findByAdresse(String adresse);
}
