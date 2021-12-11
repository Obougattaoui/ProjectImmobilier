package com.example.immob.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immob.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
