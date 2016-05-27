package com.disid.restful.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.disid.restful.model.Category;
import com.disid.restful.model.QCategory;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = CategoryRepositoryCustom.class)
public class CategoryRepositoryImpl extends QueryDslRepositorySupport{

    CategoryRepositoryImpl() {
        super(Category.class);
    }
    
    private JPQLQuery getQueryFrom(QCategory qEntity){
        return from(qEntity);
    }
}