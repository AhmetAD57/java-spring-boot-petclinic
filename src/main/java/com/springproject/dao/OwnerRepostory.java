package com.springproject.dao;

import java.util.List;

import com.springproject.model.Owner;

//Owner için CRUD
public interface OwnerRepostory {
	List<Owner> findAll();
	Owner findById(Long id);
	List<Owner> findByLastName(String lastName);
	
	void create(Owner owner);
	//güncellemede Owner döndürmesinin nedeni JPA, Hybernet(ORM) de verilen nesne ile  güncellenen nesnenin farkı  referans olmasından dolayı
	Owner update(Owner owner);
	void delete(Long id);
	
}
