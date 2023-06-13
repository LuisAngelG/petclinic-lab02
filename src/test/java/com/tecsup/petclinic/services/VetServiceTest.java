package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
	
    /**
     * antonio
    *
    */
   @Test
   public void testDeleteVet() {

       String VET_NAME = "Bird";

       // ------------ Create ---------------

       Vet vet = new Vet(VET_NAME);
       vet = this.vetService.create(vet);
       log.info("" + vet);

       // ------------ Delete ---------------

       try {
           this.vetService.delete(vet.getId());
       } catch (VetNotFoundException e) {
           fail(e.getMessage());
       }

       // ------------ Validation ---------------

       try {
           this.vetService.findById(vet.getId());
           assertTrue(false);
       } catch (VetNotFoundException e) {
           assertTrue(true);
       }

   }
	
	
}
