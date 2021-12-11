package com.example.immob.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class AppUser {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles;
	
	private String numTele;
	private String email;
	private String ville;
	private boolean isClient;	
	//Annonce :
	@OneToMany(mappedBy = "utilisateur")
	private List<Annonce> annonces;
	//Réservation :
	@OneToMany(mappedBy = "utilisateur")
	private List<Reservation> reservations;
	//Contrat
	@ManyToMany(mappedBy = "users")
	private List<Contrat> contrats;
	//Messages :
	@ManyToMany
	private List<Message> messages;
	
	@ManyToMany
	private List<Groupe> groupes;
	public AppUser() {
		super();
		this.annonces = new ArrayList<>();
		this.reservations = new ArrayList<>();
		this.contrats = new ArrayList<>();
		this.messages = new ArrayList<>();
	}
	
	public AppUser(Long id, String username, String password, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public AppUser(Long id, String username, String password, Collection<AppRole> roles, List<Message> messages) {
		super();
		this.annonces = new ArrayList<>();
		this.reservations = new ArrayList<>();
		this.contrats = new ArrayList<>();
		this.messages = new ArrayList<Message>();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.messages = messages;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	public String getNumTele() {
		return numTele;
	}
	public void setNumTele(String numTele) {
		this.numTele = numTele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public boolean isClient() {
		return isClient;
	}
	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<Contrat> getContrats() {
		return contrats;
	}
	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
}