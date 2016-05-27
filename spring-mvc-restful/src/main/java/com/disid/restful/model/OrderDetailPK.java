package com.disid.restful.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;

@RooJavaBean
@RooToString
@Embeddable
@RooEquals
public class OrderDetailPK {

    private Integer id;

    @Column(name = "customerOrderId")
    private Long customerOrderId;
}
