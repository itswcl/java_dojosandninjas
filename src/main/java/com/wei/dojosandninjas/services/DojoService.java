package com.wei.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.dojosandninjas.models.Dojo;
import com.wei.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {

	@Autowired
	private DojoRepo dojoRepo;
	
// CRUD
	// READ ALL
	public List<Dojo> displayDojos() {
		return dojoRepo.findAll();
	}


	// READ ONE
	public Dojo displayDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);

		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	// UPDATE ONE
	// CREATE ONE , this will be using as UPDATE as WELL
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}


	// DELETE ONE
	public void removeDojo(Long id) {
		dojoRepo.deleteById(id);
	}	
}
