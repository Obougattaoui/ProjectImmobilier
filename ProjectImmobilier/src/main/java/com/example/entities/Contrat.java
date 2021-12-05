package com.example.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/*
 * 
 * 
 * Ajouter attribut pour les signatures
 * 
 * 
 * */
@Entity
public class Contrat {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String informations;
	private Date date;
	//taille = 2
	@ManyToMany
	private Utilisateur[] users;
	public Contrat() {
		super();
		this.users = new Utilisateur[2];
	}
	public Contrat(Long id, String informations, Date date, Utilisateur[] users) {
		super();
		this.users = new Utilisateur[2];
		this.id = id;
		this.informations = informations;
		this.date = date;
		this.users = users;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInformations() {
		return informations;
	}
	public void setInformations(String informations) {
		this.informations = informations;
	}
	public Utilisateur[] getUsers() {
		return users;
	}
	public void setUsers(Utilisateur[] users) {
		this.users = users;
	}	
}