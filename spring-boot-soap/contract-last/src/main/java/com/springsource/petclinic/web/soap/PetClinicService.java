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

import com.springsource.petclinic.domain.OwnerInfo;
import com.springsource.petclinic.domain.PetInfo;

@WebService(name = "PetClinicService",
    targetNamespace = "http://www.petclinic.springsource.com/namespace/petservice/",
    serviceName = "PetClinicService", portName = "PetClinicService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface PetClinicService {

  @WebMethod(operationName = "GetAllPets", action = "", exclude = false)
  @WebResult(name = "return",
      targetNamespace = "http://www.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllPetsResponse",
      targetNamespace = "http://www.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllPetsResponse")
  public List<PetInfo> getAllPets();

  @WebMethod(operationName = "GetAllOwners", action = "", exclude = false)
  @WebResult(name = "return",
      targetNamespace = "http://www.petclinic.springsource.com/namespace/petservice/",
      header = false, partName = "parameters")
  @ResponseWrapper(localName = "GetAllOwnersResponse",
      targetNamespace = "http://www.petclinic.springsource.com/namespace/petservice/",
      className = "com.springsource.petclinic.web.soap.GetAllOwnersResponse")
  public List<OwnerInfo> getAllOwners();

}
