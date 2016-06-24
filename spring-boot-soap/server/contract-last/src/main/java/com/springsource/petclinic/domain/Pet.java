package com.springsource.petclinic.domain;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import com.springsource.petclinic.reference.PetType;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "PET_SEQ")
@XmlRootElement(name = "pets", namespace = "http://domain.petclinic.springsource.com/")
//@XmlType(name = "Pet", propOrder = {"petId", "name", "weight", "type", "sendReminders", "owner"},
//	    namespace = "http://domain.petclinic.springsource.com/")
//@XmlAccessorType(XmlAccessType.PROPERTY)
public class Pet {

    @Id
    @SequenceGenerator(name = "petGen", sequenceName = "PET_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "petGen")
    @Column(name = "id")
    private Long id;

    /**
     */
    @NotNull
    private boolean sendReminders;

    /**
     */
    @NotNull
    @Size(min = 1)
    private String name;

    /**
     */
    @NotNull
    @Min(0L)
    private Float weight;

    /**
     */
    @ManyToOne
    private Owner owner;

    /**
     */
    @NotNull
    @Enumerated
    private PetType type;
    
    @XmlTransient
    public Long getId() {
    	return this.id;
    }

    // @Transient if JPA uses property access
    @XmlID
    @XmlElement(name = "petId")
    public String getXmlIdentityInfo() {
        return getClass().getName() + getId();
    }

    public void setXmlIdentityInfo(String xmlId) {
        //TODO: validate xmlId is of the form <className><Long>
        setId(Long.parseLong(
            xmlId.substring( getClass().getName().length() )));
    }

    @XmlIDREF
    @XmlElement(name = "owner")
	public Owner getOwner() {
        return this.owner;
    }
}
