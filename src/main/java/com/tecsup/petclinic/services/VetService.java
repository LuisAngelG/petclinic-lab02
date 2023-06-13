package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface VetService {
	Vet create(Vet vet);

	Vet update(Vet vet);

	void delete(Integer id) throws VetNotFoundException;

	Pet findById(Integer id) throws VetNotFoundException;

	List<Vet> findByFirstName(String first);

	List<Vet> findAll();
}
