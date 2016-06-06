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
import com.disid.restful.repository.CategoryRepository;
import com.disid.restful.repository.GlobalSearch;
import com.disid.restful.service.api.CategoryService;
import com.disid.restful.service.api.ProductService;

@RooServiceImpl(service = CategoryService.class)
public class CategoryServiceImpl {

    private ProductService productService;

    private CategoryServiceImpl(CategoryRepository categoryRepository) {
	this.categoryRepository = categoryRepository;
    }

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, @Lazy ProductService productService) {
	this(categoryRepository);
	this.productService = productService;
    }

    @Transactional
    public void delete(Category category) {
	categoryRepository.delete(category);
    }

    @Transactional
    public Category addProducts(Category category, Long[] productIds) {
	Set<Product> products = updateAndGetProducts(category, productIds, true);
	category.getProducts().addAll(products);
	return categoryRepository.save(category);
    }

    private Set<Product> updateAndGetProducts(Category category, Long[] productIds, boolean addCategory) {
	Set<Product> products = productService.findByIdIn(productIds);
	for (Product product : products) {
	    if (addCategory) {
		product.getCategories().add(category);
	    } else {
		product.getCategories().remove(category);
	    }
	}
	List<Product> saved = productService.save(products);
	return new HashSet<Product>(saved);
    }

    @Transactional
    public Category deleteProducts(Category category, Long[] productIds) {
	Set<Product> products = updateAndGetProducts(category, productIds, false);
	category.getProducts().removeAll(products);
	return categoryRepository.save(category);
    }

    public Set<Category> findByIdIn(Long[] categoryIds) {
	return categoryRepository.findByIdIn(categoryIds);
    }

    public Page<Category> findAllByProduct(Product product, GlobalSearch search, Pageable pageable) {
	return categoryRepository.findAllByProduct(product, search, pageable);
    }

    public long countByProductsContains(Product product) {
	return categoryRepository.countByProductsContains(product);
    }
}
