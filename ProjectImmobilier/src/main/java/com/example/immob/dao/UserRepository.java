package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.AppUser;


public interface UserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUsername(String username);
	public AppUser findByEmail(String mail);
}
