package com.springsource.petclinic.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public abstract class AbstractPerson {

    /**
     */
    @Size(min = 3, max = 30)
    private String firstName;

    /**
     */
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    /**
     */
    @NotNull
    @Size(min = 1, max = 50)
    private String address;

    /**
     */
    @NotNull
    @Size(max = 30)
    private String city;

    /**
     */
    @NotNull
    private String telephone;

    /**
     */
    @Size(max = 30)
    private String homePage;

    /**
     */
    @Size(min = 6, max = 30)
    private String email;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthDay;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@XmlTransient
	public Long getId() {
        return this.id;
    }
}
