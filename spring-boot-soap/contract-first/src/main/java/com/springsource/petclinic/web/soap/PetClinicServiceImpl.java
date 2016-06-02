package com.springsource.petclinic.web.soap;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.domain.Pet;
import com.springsource.petclinic.namespace.petclinicservice.PetClinicService;
import com.springsource.petclinic.namespace.petclinicservice.datatypes.ArrayOfOwners;
import com.springsource.petclinic.namespace.petclinicservice.datatypes.ArrayOfPets;
import com.springsource.petclinic.namespace.petclinicservice.datatypes.ObjectFactory;
import com.springsource.petclinic.namespace.petclinicservice.general.OwnersReturn;
import com.springsource.petclinic.namespace.petclinicservice.general.PetsReturn;
import com.springsource.petclinic.reference.PetType;
import com.springsource.petclinic.service.api.OwnerService;
import com.springsource.petclinic.service.api.PetService;

public class PetClinicServiceImpl implements PetClinicService {

	private PetService petService;
	private OwnerService ownerService;

	private ObjectFactory objectFactoryDataTypes;

	public PetClinicServiceImpl(PetService petService, OwnerService ownerService) {
		this.petService = petService;
		this.ownerService = ownerService;

		objectFactoryDataTypes = new ObjectFactory();
	}

	@Override
	public PetsReturn getAllPets() {
		// Generating pets return
		PetsReturn petsReturn = new PetsReturn();

		// Generating array of pets
		ArrayOfPets arrayOfPets = this.objectFactoryDataTypes.createArrayOfPets();

		// Obtaining pets using service
		List<Pet> pets = this.petService.findAll();

		// Adding pets to arrayOfPets
		for (Pet pet : pets) {
			arrayOfPets.getPet().add(convertFromPetToWsPet(pet));
		}

		petsReturn.setPets(arrayOfPets);
		petsReturn.setResponseText("OK");
		petsReturn.setSuccess(true);

		return petsReturn;
	}
	
	@Override
	public OwnersReturn getAllOwners() {
		// Generating owners return
		OwnersReturn ownersReturn = new OwnersReturn();

		// Generating array of owners
		ArrayOfOwners arrayOfOwners = this.objectFactoryDataTypes.createArrayOfOwners();

		// Obtaining owners using service
		List<Owner> owners = this.ownerService.findAll();

		// Adding owners to arrayOfOwners
		for (Owner owner : owners) {
			arrayOfOwners.getOwner().add(convertFromOwnerToWsOwner(owner));
		}

		ownersReturn.setOwners(arrayOfOwners);
		ownersReturn.setResponseText("OK");
		ownersReturn.setSuccess(true);

		return ownersReturn;
	}

	/**
	 * Method that receives a domain Pet element and returns its equivalent to
	 * the Web Service Schema
	 * 
	 * @param pet
	 * @return
	 */
	public com.springsource.petclinic.namespace.petclinicservice.datatypes.Pet convertFromPetToWsPet(Pet pet) {
		com.springsource.petclinic.namespace.petclinicservice.datatypes.Pet wsPet = this.objectFactoryDataTypes
				.createPet();
		wsPet.setId(pet.getId());
		wsPet.setName(pet.getName());
		wsPet.setWeight(pet.getWeight());
		wsPet.setSendReminders(pet.isSendReminders());
		if (pet.getOwner() != null) {
			wsPet.setOwner(convertFromOwnerToWsOwner(pet.getOwner()));
		}
		wsPet.setType(convertFromPetTypeToWsPetType(pet.getType()));

		return wsPet;
	}

	/**
	 * Method that receives a domain Owner element and returns its equivalent to
	 * the Web Service Schema
	 * 
	 * @param owner
	 * @return
	 */
	public com.springsource.petclinic.namespace.petclinicservice.datatypes.Owner convertFromOwnerToWsOwner(
			Owner owner) {
		com.springsource.petclinic.namespace.petclinicservice.datatypes.Owner wsOwner = this.objectFactoryDataTypes
				.createOwner();
		wsOwner.setId(owner.getId());
		wsOwner.setFirstName(owner.getFirstName());
		wsOwner.setLastName(owner.getLastName());
		wsOwner.setAddress(owner.getAddress());
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(owner.getBirthDay());
			XMLGregorianCalendar birthday = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			wsOwner.setBirthDay(birthday);
		} catch (DatatypeConfigurationException ex) {
			// TODO: Log the exception
		}

		wsOwner.setCity(owner.getCity());
		wsOwner.setEmail(owner.getEmail());
		wsOwner.setHomePage(owner.getHomePage());
		wsOwner.setTelephone(owner.getTelephone());

		return wsOwner;
	}

	/**
	 * Method that receives a domain PetType object and returns its equivalent
	 * to the Web Service Schema
	 * 
	 * @param petType
	 * @return
	 */
	public com.springsource.petclinic.namespace.petclinicservice.datatypes.PetType convertFromPetTypeToWsPetType(
			PetType petType) {
		return com.springsource.petclinic.namespace.petclinicservice.datatypes.PetType.fromValue(petType.name());
	}

}
