package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

@SpringBootTest
@Slf4j
public class VetServiceTest {
	
	
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
