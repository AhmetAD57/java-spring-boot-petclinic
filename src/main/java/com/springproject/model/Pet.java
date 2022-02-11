package com.springproject.model;

import java.util.Date;

//Domain class
public class Pet {
	private Long id;
	private String name;
	private Date birthDay;

	private Owner owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", owner=" + owner + "]";
	}

}
