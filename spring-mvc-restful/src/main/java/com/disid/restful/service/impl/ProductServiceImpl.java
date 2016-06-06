package com.disid.restful.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.disid.restful.model.Category;
import com.disid.restful.model.Product;
import com.disid.restful.repository.GlobalSearch;
import com.disid.restful.repository.ProductRepository;
import com.disid.restful.service.api.CategoryService;
import com.disid.restful.service.api.ProductService;

@RooServiceImpl(service = ProductService.class)
public class ProductServiceImpl {

    private CategoryService categoryService;

    private ProductServiceImpl(ProductRepository productRepository) {
	this.productRepository = productRepository;
    }

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, @Lazy CategoryService categoryService) {
	this(productRepository);
	this.categoryService = categoryService;
    }

    @Transactional
    public void delete(Product product) {
	productRepository.delete(product);
    }

    public Page<Product> findAllByCategory(Category category, GlobalSearch search, Pageable pageable) {
	return productRepository.findAllByCategoriesContains(category, search, pageable);
    }

    public long countByCategoriesContains(Category category) {
	return productRepository.countByCategoriesContains(category);
    }

    public Set<Product> findByIdIn(Long[] productIds) {
	return productRepository.findByIdIn(productIds);
    }

    @Transactional
    public Product addCategories(Product product, Long[] categoryIds) {
	Set<Category> categories = updateAndGetCategories(product, categoryIds, true);
	product.getCategories().addAll(categories);
	return productRepository.save(product);
    }

    private Set<Category> updateAndGetCategories(Product product, Long[] categoryIds, boolean addProduct) {
	Set<Category> categories = categoryService.findByIdIn(categoryIds);
	for (Category category : categories) {
	    if (addProduct) {
		category.getProducts().add(product);
	    } else {
		category.getProducts().remove(product);
	    }
	}
	List<Category> saved = categoryService.save(categories);
	return new HashSet<Category>(saved);
    }

    @Transactional
    public Product deleteCategories(Product product, Long[] categoryIds) {
	Set<Category> categories = updateAndGetCategories(product, categoryIds, false);
	product.getCategories().removeAll(categories);
	return productRepository.save(product);
    }

}
