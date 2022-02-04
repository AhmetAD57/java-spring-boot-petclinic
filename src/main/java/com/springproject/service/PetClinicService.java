package com.springproject.service;

import java.util.List;

import com.springproject.exception.OwnerNotFoundException;
import com.springproject.model.Owner;
import com.springproject.model.Pet;

//Servis katmanı
public interface PetClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwner(Long id) throws OwnerNotFoundException;
	
	void createOwner(Owner owner);
	// güncellemede Pet döndürmesinin nedeni JPA, Hybernet(ORM) de verilen nesne ile  güncellenen nesnenin farkı  referanslı olmasından dolayı
	void update(Owner owner);
	void deleteOwner(Long id);
	
}
