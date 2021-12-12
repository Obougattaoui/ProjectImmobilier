package com.example.immob.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Annonce {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String ville;
	private double prix;
	private AnnonceType annonceType;
	private MaisonType maisonType;
	//Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private AppUser utilisateur;
		
	@OneToOne(mappedBy = "annonce")
	private Reservation reservation;
	@OneToOne
	private Immobilier immobilier;
	
	
	
	public Annonce() {
		super();
	}
	
	public Annonce(Long id, String name, String description, String ville, double prix, AnnonceType annonceType,
			MaisonType maisonType, AppUser utilisateur, Reservation reservation, Immobilier immobilier) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ville = ville;
		this.prix = prix;
		this.annonceType = annonceType;
		this.maisonType = maisonType;
		this.utilisateur = utilisateur;
		this.reservation = reservation;
		this.immobilier = immobilier;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public AnnonceType getAnnonceType() {
		return annonceType;
	}
	public void setAnnonceType(AnnonceType annonceType) {
		this.annonceType = annonceType;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Immobilier getImmobilier() {
		return immobilier;
	}
	public void setImmobilier(Immobilier immobilier) {
		this.immobilier = immobilier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppUser getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(AppUser utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MaisonType getMaisonType() {
		return maisonType;
	}

	public void setMaisonType(MaisonType maisonType) {
		this.maisonType = maisonType;
	}
	
	
}
