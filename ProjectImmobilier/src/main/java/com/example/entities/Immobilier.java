package com.example.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Immobilier {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private ImmobilierType immobilierType;
	private String adresse;
	private String descriprion;
	private Collection<File> images = new ArrayList<File>();
	@OneToOne(mappedBy = "immobilier")
	private Annonce annonce;
	public Immobilier() {
		super();
	}
	
	public Immobilier(Long id, ImmobilierType immobilierType, String adresse, String descriprion,
			Collection<File> images, Annonce annonce) {
		super();
		this.id = id;
		this.immobilierType = immobilierType;
		this.adresse = adresse;
		this.descriprion = descriprion;
		this.images = images;
		this.annonce = annonce;
	}

	public ImmobilierType getImmobilierType() {
		return immobilierType;
	}
	public void setImmobilierType(ImmobilierType immobilierType) {
		this.immobilierType = immobilierType;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDescriprion() {
		return descriprion;
	}
	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}
	public Collection<File> getImages() {
		return images;
	}
	public void setImages(Collection<File> images) {
		this.images = images;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
}