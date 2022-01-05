package com.example.immob.service;

import com.example.immob.entities.AppUser;
import com.example.immob.entities.Contrat;

public interface ContratService {
	//ajouter une contrat :
	public Contrat saveContrat(Contrat contrat);
	//chercher une contart :
	public Contrat findContratById(Long id);
	//chercher toures les contratsb d'un user :
	public Contrat findContratByUser(AppUser user1);
	//supprimer une contrat 
	public Contrat deleteContrat(Long id);
	
}
