package com.tecsup.petclinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity(name = "vets")
@Data
public class Vet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	
	public Vet() {
	}

	public Vet(Integer id, String first_name, String last_name) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;

	}

	public Vet(String first_name, String last_name) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
	}
}
