package com.springsource.petclinic.web.soap;

import java.util.List;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.domain.Pet;

public interface PetClinicService {
	
	public List<Pet> getAllPets();
	
	public List<Owner> getAllOwners();

}
