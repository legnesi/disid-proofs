package com.disid.restful.model;

import javax.persistence.EmbeddedId;
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
    @EmbeddedId
    private OrderDetailPK id;

    /**
     */
    private Integer quantity;

    /**
     */
    @ManyToOne
    @MapsId("customerOrderId")
    private CustomerOrder customerOrder;

    /**
     */
    @ManyToOne
    private Product product;
}
