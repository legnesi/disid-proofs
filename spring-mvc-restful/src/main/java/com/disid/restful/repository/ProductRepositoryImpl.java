package com.disid.restful.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.disid.restful.model.Product;
import com.disid.restful.model.QProduct;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = ProductRepositoryCustom.class)
public class ProductRepositoryImpl extends QueryDslRepositorySupport{

    ProductRepositoryImpl() {
        super(Product.class);
    }
    
    private JPQLQuery getQueryFrom(QProduct qEntity){
        return from(qEntity);
    }
}