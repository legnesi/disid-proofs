package com.disid.restful.service.api;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;
import com.disid.restful.repository.GlobalSearch;

@RooService(entity = Product.class)
public interface ProductService {

    void delete(Product product);

    Page<Product> findAllByCategory(Category category, GlobalSearch search, Pageable pageable);

    long countByCategoriesContains(Category category);

    Set<Product> findByIdIn(Long[] productIds);

    Product addToCategories(Product product, Long... categories);

    Product deleteFromCategories(Product product, Long... categories);
}
