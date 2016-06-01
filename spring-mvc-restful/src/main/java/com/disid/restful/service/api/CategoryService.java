package com.disid.restful.service.api;

import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.disid.restful.model.Category;

@RooService(entity = Category.class)
public interface CategoryService {

    void delete(Category category);

    Category setProducts(Category category, Long[] products);

    Category addProducts(Category category, Long[] products);

    Category deleteProducts(Category category, Long[] products);
}
