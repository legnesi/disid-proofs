package com.disid.restful.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RooJavaBean
@RooToString
@RooJpaEntity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
public class Product {

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<Category> categories = new HashSet<Category>();
}
