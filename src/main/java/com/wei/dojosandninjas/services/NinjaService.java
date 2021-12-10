package com.wei.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.dojosandninjas.models.Ninja;
import com.wei.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
// CRUD
	// READ ALL
	public List<Ninja> displayNinjas() {
		return ninjaRepo.findAll();
	}
	
	
	// READ ONE
	public Ninja displayNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	// UPDATE ONE
	// CREATE ONE , this will be using as UPDATE as WELL
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
		
	
	// DELETE ONE
	public void removeNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
