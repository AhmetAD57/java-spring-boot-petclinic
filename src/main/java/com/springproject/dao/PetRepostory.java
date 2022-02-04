package com.springproject.dao;

import java.util.List;

import com.springproject.model.Owner;
import com.springproject.model.Pet;
public interface PetRepostory {
	Pet findById(Long id);
	List<Pet> findByOwnerId(Long id);
	
	void create(Pet pet);
	// güncellemede Pet döndürmesinin nedeni JPA, Hybernet(ORM) de verilen nesne ile  güncellenen nesnenin farkı  referanslı olmasından dolayı
	Pet update(Pet pet);
	void delete(Long id);
	void deleteByOwnerId(Long ownerId);
}
