package com.disid.restful.repository;
import com.disid.restful.model.Category;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(entity = Category.class)
public interface CategoryRepository {
}
