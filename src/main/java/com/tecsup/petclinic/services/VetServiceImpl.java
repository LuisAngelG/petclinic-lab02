package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;

public class VetServiceImpl {
	VetRepository vetRepository;

	public VetServiceImpl (VetRepository vetRepository) {
		this. vetRepository = vetRepository;
	}


	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Vet create(Vet vet) {
		return vetRepository.save(vet);
	}

	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Vet update(Vet vet) {
		return vetRepository.save(vet);
	}


	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	@Override
	public void delete(Integer id) throws VetNotFoundException{

		Vet vet = findById(id);
		vetRepository.delete(vet);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Vet findById(Integer id) throws VetNotFoundException {

		Optional<Vet> vet = vetRepository.findById(id);

		if ( !vet.isPresent())
			throw new VetNotFoundException("Record not found...!");
			
		return vet.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Vet> findByFirstName(String firstName) {

		List<Vet> vets = vetRepository.findByFirstName(firstName);

		vets.stream().forEach(vet -> log.info("" + vet));

		return vets;
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	@Override
	public List<Pet> findByTypeId(int typeId) {

		List<Pet> pets = petRepository.findByTypeId(typeId);

		pets.stream().forEach(pet -> log.info("" + pet));

		return pets;
	}

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<Pet> findByOwnerId(int ownerId) {

		List<Pet> pets = petRepository.findByOwnerId(ownerId);

		pets.stream().forEach(pet -> log.info("" + pet));

		return pets;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<Pet> findAll() {
		//
		return petRepository.findAll();

	}
}
