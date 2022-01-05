package com.example.immob.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.immob.dao.ImmobilierRepository;
import com.example.immob.entities.Immobilier;

public class ImmobilierServiceImpl implements ImmobilierService{
	@Autowired
	ImmobilierRepository immobilierRepository;
	@Override
	public Immobilier saveImmobilier(Immobilier immobilier) {
		return immobilierRepository.save(immobilier);
	}

	@Override
	public Immobilier findImmobilierById(Long id) {
		Optional<Immobilier> immobilier = immobilierRepository.findById(id);
		if (!immobilier.isPresent())
			throw new RuntimeException("l'immobilier d'id : " + id + " n'existe pas");
		return immobilier.get();
	}

	@Override
	public Immobilier findImmobilierByAdresse(String adresse) {
		Immobilier immobilier = immobilierRepository.findByAdresse(adresse);
		if (immobilier == null)
			throw new RuntimeException("l'adresse:  " + adresse + " n'existe pas");
		return immobilier;
	}

	@Override
	public void deleteImmobilier(Immobilier immobilier) {
		if (!immobilierRepository.existsById(immobilier.getId()))
			throw new RuntimeException("cet immobilier n'existe pas");
		immobilierRepository.delete(immobilier);
		
	}

	@Override
	public Immobilier updateImmobilier(Long id, Immobilier newImmobilier) {
		Immobilier immobilier = this.findImmobilierById(id);
		immobilier.setAdresse(newImmobilier.getAdresse());
		immobilier.setAnnonce(newImmobilier.getAnnonce());
		immobilier.setDescriprion(newImmobilier.getDescriprion());
		return immobilier;
	}

}
