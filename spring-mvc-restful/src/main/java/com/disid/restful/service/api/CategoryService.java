package com.disid.restful.service.api;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;
import com.disid.restful.repository.GlobalSearch;

@RooService(entity = Category.class)
public interface CategoryService {

    void delete(Category category);

    Category addProducts(Category category, Long[] products);

    Category deleteProducts(Category category, Long[] products);

    Set<Category> findByIdIn(Long[] categoryIds);

    Page<Category> findAllByProduct(Product product, GlobalSearch search, Pageable pageable);

    long countByProductsContains(Product product);

}
