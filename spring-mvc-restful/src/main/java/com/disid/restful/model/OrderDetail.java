package com.disid.restful.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public class OrderDetail {

    /**
     */
    private Integer quantity;

    /**
     */
    @ManyToOne
    private Product product;

    /**
     */
    @ManyToOne
    @MapsId("customerOrderId")
    @JoinColumn(name = "customerOrderId", referencedColumnName = "id")
    private CustomerOrder customerOrder;

    /**
     */
    private OrderDetailPK id;
}
