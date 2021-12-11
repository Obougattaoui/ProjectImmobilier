package com.example.immob.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@JoinTable(name = "contrats_users", 
				joinColumns = @JoinColumn(name="contrat_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id")
			)
	private List<AppUser> users;
	
	
	public Contrat() {
		super();
		this.users = new ArrayList<>();
	}
	public Contrat(Long id, String informations, Date date, List<AppUser> users) {
		super();
		this.users = new ArrayList<>();
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
	public List<AppUser> getUsers() {
		return users;
	}
	public void setUsers(List<AppUser> users) {
		this.users = users;
	}

}