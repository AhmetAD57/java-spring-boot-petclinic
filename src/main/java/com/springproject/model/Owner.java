package com.springproject.model;

import java.util.HashSet;
import java.util.Set;

//Domain class
public class Owner {
	private Long id;
	private String FirtName;
	private String lastName;
	
	private Set<Pet> pets = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirtName() {
		return FirtName;
	}

	public void setFirtName(String firtName) {
		FirtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", FirtName=" + FirtName + ", lastName=" + lastName + "]";
	}
}
