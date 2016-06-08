package com.springsource.petclinic.web.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.domain.OwnerInfo;
import com.springsource.petclinic.domain.Pet;
import com.springsource.petclinic.domain.PetInfo;

@WebService(name = "PetClinicWebService",
    targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
    serviceName = "PetClinicWebService", portName = "PetClinicWebService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface PetClinicWebService {

  @WebMethod(operationName = "GetAllPets", action = "", exclude = false)
  @WebResult(name = "pet",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllPetsResponse",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllPetsResponse")
  public List<Pet> getAllPets();

  @WebMethod(operationName = "GetAllPetInfos", action = "", exclude = false)
  @WebResult(name = "petInfo",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllPetInfosResponse",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllPetInfosResponse")
  public List<PetInfo> getAllPetInfos();

  @WebMethod(operationName = "GetAllOwners", action = "", exclude = false)
  @WebResult(name = "owner",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllOwnersResponse",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllOwnersResponse")
  public List<Owner> getAllOwners();

  @WebMethod(operationName = "GetAllOwnerInfos", action = "", exclude = false)
  @WebResult(name = "ownerInfo",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllOwnerInfosResponse",
      targetNamespace = "http://soap.web.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllOwnerInfosResponse")
  public List<OwnerInfo> getAllOwnerInfos();

}
