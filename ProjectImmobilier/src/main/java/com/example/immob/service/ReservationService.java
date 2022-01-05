package com.example.immob.service;

import java.util.List;

import com.example.immob.entities.AppUser;
import com.example.immob.entities.Reservation;

public interface ReservationService {
	//Ajouter une reservation :
	public Reservation saveReservation(Reservation reservation);
	//chercher une reservation par id:
	public Reservation findReservationById(Long id);
	//chercher une reservation par user :
	public List<Reservation> findReservationByUser(AppUser user);
	//update Reservation :
	public Reservation updateReservation(Long id, Reservation newReservation);
	//delete reservation :
	public void deleteReservation(Reservation reservation);
	//toutes les réservations :
	public List<Reservation> allReservations();
}
