package com.disid.restful.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity
public class CustomerOrder {

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date orderDate;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date shippedDate;

    /**
     */
    private String shipAddress;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<OrderDetail> details = new HashSet<OrderDetail>();

    /**
     */
    @ManyToOne
    private Customer customer;
}
