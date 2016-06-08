package com.springsource.petclinic.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
@XmlRootElement(name = "owners", namespace = "http://domain.petclinic.springsource.com/")
//@XmlType(name = "Owner", propOrder = {"ownerId", "firstName", "lastName", "address", "city", "telephone",
//	    "homePage", "email", "birthDay", "pets"}, namespace = "http://domain.petclinic.springsource.com/")
//@XmlAccessorType(XmlAccessType.PROPERTY)
public class Owner extends AbstractPerson {

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<Pet>();

    // @Transient if JPA uses property access
    @XmlID
    @XmlElement(name = "ownerId")
    public String getXmlIdentityInfo() {
        return getClass().getName() + getId();
    }

    public void setXmlIdentityInfo(String xmlId) {
        //TODO: validate xmlId is of the form <className><Long>
        setId(Long.parseLong(
            xmlId.substring( getClass().getName().length() )));
    }

    @XmlElement(name = "pet")
	public Set<Pet> getPets() {
        return this.pets;
    }
}
