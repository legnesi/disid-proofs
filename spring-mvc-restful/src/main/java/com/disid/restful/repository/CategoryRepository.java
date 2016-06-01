package com.disid.restful.repository;

import java.util.Set;

import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;

@RooJpaRepository(entity = Category.class)
public interface CategoryRepository {

    Set<Category> findByIdIn(Long[] categoryIds);

    long countByProductsContains(Product product);
}
