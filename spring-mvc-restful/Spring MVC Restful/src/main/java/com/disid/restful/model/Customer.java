package com.disid.restful.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Customer {

    /**
     */
    private String firstName;

    /**
     */
    private String lastName;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CustomerOrder> orders = new HashSet<CustomerOrder>();
}
