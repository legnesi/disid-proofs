package com.springsource.petclinic.web.soap;

import java.util.ArrayList;
import java.util.List;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.domain.Pet;
import com.springsource.petclinic.service.api.OwnerService;
import com.springsource.petclinic.service.api.PetService;
import com.springsource.petclinic.ws.PetClinicServicePortType;

public class PetClinicServiceImpl implements PetClinicServicePortType {
  
  private PetService petService;
  private OwnerService ownerService;
  
  public PetClinicServiceImpl(PetService petService, OwnerService ownerService){
    this.petService = petService;
    this.ownerService = ownerService;
  }

  @Override
  public List<Object> getAllPets() {
    List<Pet> pets = this.petService.findAll();
    return new ArrayList<Object>(pets);
  }

  @Override
  public List<Object> getAllOwners() {
    List<Owner> owners = this.ownerService.findAll();
    return new ArrayList<Object>(owners);
  }

}
