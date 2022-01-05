package com.example.immob.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.AppUser;
import com.example.immob.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	public List<Reservation> findByUtilisateur(AppUser utilisateur);
}
