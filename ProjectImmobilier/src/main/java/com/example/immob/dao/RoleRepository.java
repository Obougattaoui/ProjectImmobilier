package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
	public AppRole findByRoleName(String roleName);
}
