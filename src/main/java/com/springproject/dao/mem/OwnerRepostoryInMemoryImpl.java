package com.springproject.dao.mem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.springproject.dao.OwnerRepostory;
import com.springproject.model.Owner;

@Repository // Spring container çalışma zamanında bir bean oluşturur.
public class OwnerRepostoryInMemoryImpl implements OwnerRepostory {

	private Map<Long, Owner> ownersMap = new HashMap<>();

	public OwnerRepostoryInMemoryImpl() {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Cafer");
		owner1.setLastName("Nuri");

		Owner owner2 = new Owner();
		owner2.setId(5L);
		owner2.setFirstName("Tim");
		owner2.setLastName("Cook");
		
		Owner owner3 = new Owner();
		owner3.setId(4L);
		owner3.setFirstName("Rock");
		owner3.setLastName("Dog");

		ownersMap.put(owner1.getId(), owner1);
		ownersMap.put(owner2.getId(), owner2);
		ownersMap.put(owner3.getId(), owner3);
	}

	@Override
	public List<Owner> findAll() {
		return new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owner findById(Long id) {
		return ownersMap.get(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		return ownersMap.values().stream().filter(o -> o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(), owner);

	}

	@Override
	public Owner update(Owner owner) {
		ownersMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(Long id) {
		ownersMap.remove(id);

	}

}
