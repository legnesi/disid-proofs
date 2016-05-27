package com.disid.restful.repository;
import com.disid.restful.model.Product;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

@RooJpaRepositoryCustom(entity = Product.class, defaultSearchResult = Product.class)
public interface ProductRepositoryCustom {
}
