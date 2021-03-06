package com.example.immob.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Annonce {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String ville;
	private String adresse;
	private double prix;
	private AnnonceType annonceType;
	private MaisonType maisonType;
	private boolean estReserve;
	//images :
	@OneToMany(mappedBy = "annonce", fetch = FetchType.LAZY)
	private transient List<ImageModel> images;
	//Utilisateur
	@ManyToOne()
	@JoinColumn(name="utilisateur_id")
	private AppUser utilisateur;
	
	public Annonce() {
		super();
		images = new ArrayList<>();
	}
	public Annonce(Long id, String name, String description, String ville, double prix, AnnonceType annonceType,
			MaisonType maisonType, List<ImageModel> images, AppUser utilisateur, String adresse, boolean estReserve) {
		super();
		images = new ArrayList<>();
		this.id = id;
		this.adresse = adresse;
		this.name = name;
		this.description = description;
		this.ville = ville;
		this.prix = prix;
		this.annonceType = annonceType;
		this.maisonType = maisonType;
		this.images = images;
		this.utilisateur = utilisateur;
		this.estReserve = estReserve;
	}

	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<ImageModel> getImages() {
		return images;
	}
	public void setImages(List<ImageModel> images) {
		this.images = images;
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
	public boolean isEstReserve() {
		return estReserve;
	}
	public void setEstReserve(boolean estReserve) {
		this.estReserve = estReserve;
	}
}
