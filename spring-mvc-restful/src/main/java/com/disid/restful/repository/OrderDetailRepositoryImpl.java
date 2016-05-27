package com.disid.restful.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.disid.restful.model.OrderDetail;
import com.disid.restful.model.QOrderDetail;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = OrderDetailRepositoryCustom.class)
public class OrderDetailRepositoryImpl extends QueryDslRepositorySupport{

    OrderDetailRepositoryImpl() {
        super(OrderDetail.class);
    }
    
    private JPQLQuery getQueryFrom(QOrderDetail qEntity){
        return from(qEntity);
    }
}