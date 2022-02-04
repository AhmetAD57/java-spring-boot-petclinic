package com.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.dao.OwnerRepostory;
import com.springproject.exception.OwnerNotFoundException;
import com.springproject.model.Owner;

@Service //Spring container ın ilgili classdan been oluşturmasının sağlıyor 
public class PetClinicServiceImpl implements PetClinicService{

	private OwnerRepostory ownerRepostory;
	
	@Autowired//bu metot sayesinde spring container OwnerRepostory tipindeki bean i petclinicservice bean inin içine enjekte eder
	public void setOwnerRepostory(OwnerRepostory ownerRepostory) {
		this.ownerRepostory = ownerRepostory;
	}
		
	@Override
	public List<Owner> findOwners() {
		return ownerRepostory.findAll();
	}

	@Override
	public List<Owner> findOwners(String lastName) {
		return ownerRepostory.findByLastName(lastName);
	}
	@Override
	public Owner findOwner(Long id) throws OwnerNotFoundException{
		Owner owner = ownerRepostory.findById(id);
		if(owner == null) throw new OwnerNotFoundException("Owner not found with id: " + id);
		return owner;
	}
	
	@Override
	public void createOwner(Owner owner) {
		ownerRepostory.create(owner);
		
	}

	@Override
	public void update(Owner owner) {
		ownerRepostory.update(owner);
		
	}

	@Override
	public void deleteOwner(Long id) {
		ownerRepostory.delete(id);
		
	}

}
