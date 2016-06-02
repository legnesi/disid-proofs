package com.springsource.petclinic.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import com.sun.xml.bind.CycleRecoverable;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Owner extends AbstractPerson implements CycleRecoverable {

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<Pet>();

	@Override
	public Object onCycleDetected(Context arg0) {
		return new Owner();
	}
}
