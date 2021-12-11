package com.example.immob.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String note;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private AppUser utilisateur;
	
	
	@OneToOne
	private Annonce annonce;
	public Reservation() {
		super();
	}
	public Reservation(Long id, Date date, String note, AppUser utilisateur, Annonce annonce) {
		super();
		this.id = id;
		this.date = date;
		this.note = note;
		this.utilisateur = utilisateur;
		this.annonce = annonce;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public AppUser getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(AppUser utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
}
