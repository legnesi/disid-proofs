package com.springsource.petclinic.web.soap;

import java.util.ArrayList;
import java.util.List;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.domain.OwnerInfo;
import com.springsource.petclinic.domain.Pet;
import com.springsource.petclinic.domain.PetInfo;
import com.springsource.petclinic.service.api.OwnerService;
import com.springsource.petclinic.service.api.PetService;


public class PetClinicWebServiceEndpoint implements PetClinicWebService {

  private PetService petService;
  private OwnerService ownerService;

  public PetClinicWebServiceEndpoint() {

  }

  public PetClinicWebServiceEndpoint(PetService petService, OwnerService ownerService) {
    this.petService = petService;
    this.ownerService = ownerService;
  }


  public List<PetInfo> getAllPetInfos() {
    List<Pet> pets = this.petService.findAll();
    List<PetInfo> petInfo = new ArrayList<PetInfo>();

    for (Pet pet : pets) {
      petInfo.add(new PetInfo(pet.getId(), pet.isSendReminders(), pet.getName(), pet.getWeight(), getOwnerInfo(pet.getOwner()),
          pet.getType()));
    }
    return petInfo;
  }

  public List<OwnerInfo> getAllOwnerInfos() {
    List<Owner> owners = this.ownerService.findAll();
    List<OwnerInfo> ownerInfo = new ArrayList<OwnerInfo>();

    for (Owner owner : owners) {
      ownerInfo.add(getOwnerInfo(owner));
    }

    return ownerInfo;

  }

  @Override
  public List<Pet> getAllPets() {
    List<Pet> pets = this.petService.findAll();
    return pets;
  }

  public List<Owner> getAllOwners() {
	  List<Owner> owners = this.ownerService.findAll();
	  return owners;
  }

  /**
   * Method that obtain an OwnerInfo data transfer object from
   * entity Owner.
   * 
   * @param owner
   * @return OwnerInfo DTO
   */
  private OwnerInfo getOwnerInfo(Owner owner){
    return new OwnerInfo(owner.getId(), owner.getFirstName(), owner.getLastName(),
        owner.getAddress(), owner.getCity(), owner.getTelephone(), owner.getHomePage(),
        owner.getEmail(), owner.getBirthDay());
  }

}
