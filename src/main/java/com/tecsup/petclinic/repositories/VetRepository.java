package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Vet;

/**
 * 
 * @author asantiago
 *
 */
@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Integer> {

	// Fetch pets by name
	List<Vet> findByFirst_name(String first_name);

	// Fetch pets by typeId
	List<Vet> findByLast_name(int last_name);

	@Override
	List<Vet> findAll();

}
