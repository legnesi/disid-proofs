package com.disid.restful.repository;
import com.disid.restful.model.Category;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

@RooJpaRepositoryCustom(entity = Category.class, defaultSearchResult = Category.class)
public interface CategoryRepositoryCustom {
}
