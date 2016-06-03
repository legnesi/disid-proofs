package com.springsource.petclinic.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.springsource.petclinic.reference.PetType;

/**
 * Data Transfer Object of Owner Entity
 */
@XmlRootElement(name = "petInfo", namespace = "http://www.petclinic.springsource.com/")
@XmlType(name = "PetInfo", propOrder = {"id", "sendReminders", "name", "weight", "ownerInfo", "type"},
    namespace = "http://domain.petclinic.springsource.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class PetInfo {

  @XmlElement(name = "id")
  private final Long id;

  @XmlElement(name = "sendReminders")
  private final boolean sendReminders;

  @XmlElement(name = "name")
  private final String name;

  @XmlElement(name = "weight")
  private final Float weight;
  
  @XmlElement(name = "owner")
  private final OwnerInfo ownerInfo;

  @XmlElement(name = "type")
  private final PetType type;

  public PetInfo() {
    this.id = null;
    this.sendReminders = false;
    this.name = null;
    this.weight = null;
    this.ownerInfo = null;
    this.type = null;
  }

  public PetInfo(Long id, boolean sendReminders, String name, Float weight, OwnerInfo owner, PetType type) {
    this.id = id;
    this.sendReminders = sendReminders;
    this.name = name;
    this.weight = weight;
    this.ownerInfo = owner;
    this.type = type;
  }

  public Long getId() {
    return this.id;
  }

  public boolean isSendReminders() {
    return this.sendReminders;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Float getWeight() {
    return this.weight;
  }
  
  public PetType getType() {
    return this.type;
  }

}
