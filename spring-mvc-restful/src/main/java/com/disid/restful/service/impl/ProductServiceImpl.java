package com.disid.restful.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;
import com.disid.restful.repository.GlobalSearch;
import com.disid.restful.service.api.ProductService;

@RooServiceImpl(service = ProductService.class)
public class ProductServiceImpl {

    public void delete(Product product) {
	productRepository.delete(product);
    }

    public Page<Product> findAllByCategory(Category category, GlobalSearch search, Pageable pageable) {
	return productRepository.findAllByCategoriesContains(category, search, pageable);
    }

    public long countByCategoriesContains(Category category) {
	return productRepository.countByCategoriesContains(category);
    }
}
