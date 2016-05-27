package com.disid.restful.model;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.javabean.annotations.RooEquals;

@RooJavaBean
@RooToString
@Embeddable
@RooEquals
public class OrderDetailPK {

    @Id
    private Integer id;

    @Id
    private Long customerOrderId;
}
