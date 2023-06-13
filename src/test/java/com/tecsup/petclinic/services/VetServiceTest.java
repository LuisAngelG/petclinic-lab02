package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;

@SpringBootTest
@Slf4j
public class VetServiceTest {
	
	@Autowired
	private VetService vetService;
	
	@Test
	 public void testCreateVet() {

       String FIRST_NAME = "Luis";
       String LAST_NAME = "Gastelu";

       Vet vet = new Vet(FIRST_NAME, LAST_NAME);

       Vet vetCreated = this.vetService.create(vet);

       log.info("VETS CREATED :" + vetCreated);

       assertNotNull(vet.getId());
       assertEquals(FIRST_NAME, vet.getFirstName());
       assertEquals(LAST_NAME, vet.getLastName());

   }
	
}
