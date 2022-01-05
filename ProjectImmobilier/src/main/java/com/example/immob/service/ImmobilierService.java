package com.example.immob.service;

import com.example.immob.entities.Immobilier;

public interface ImmobilierService {
	//ajouter un immobilier :
	public Immobilier saveImmobilier(Immobilier immobilier);
	//chercher un immobilier:
	public Immobilier findImmobilierById(Long id);
	//chercher un immobilier par son adresse :
	public Immobilier findImmobilierByAdresse(String adresse);
	//supprimer un immobilier :
	public void deleteImmobilier(Immobilier immobilier);
	//update un immobilier :
	public Immobilier updateImmobilier(Long id, Immobilier newImmobilier);
}
