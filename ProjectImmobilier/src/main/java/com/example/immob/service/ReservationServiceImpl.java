package com.example.immob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.immob.dao.ReservationRepository;
import com.example.immob.entities.AppUser;
import com.example.immob.entities.Reservation;

public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation findReservationById(Long id) {
		Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("cette reservation n'existe pas");});
		return reservation;
	}

	@Override
	public List<Reservation> findReservationByUser(AppUser user) {
		List<Reservation> reservations = reservationRepository.findByUtilisateur(user);
		if (reservations == null)
			throw new RuntimeException("aucune reservation d'utilisateur : " + user.getUsername() + " existe");
		return reservations;
	}

	@Override
	public Reservation updateReservation(Long id, Reservation newReservation) {
		Reservation reservation = this.findReservationById(id);
		reservation.setDate(newReservation.getDate());
		reservation.setNote(newReservation.getNote());
		reservation.setUtilisateur(newReservation.getUtilisateur());
		reservation.setAnnonce(newReservation.getAnnonce());
		return reservation;
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		if (!reservationRepository.existsById(reservation.getId()))
			throw new RuntimeException("cette reservation n'existe pas");
		reservationRepository.delete(reservation);
	}
	@Override
	public List<Reservation> allReservations() {
		List<Reservation> reservations = reservationRepository.findAll();
		if(reservations == null)
			throw new RuntimeException("aucune réservation existe");
		return reservations;
	}
}
