package com.disid.restful.service.impl;

import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.Category;
import com.disid.restful.service.api.CategoryService;

@RooServiceImpl(service = CategoryService.class)
public class CategoryServiceImpl {

    public void delete(Category category) {
	categoryRepository.delete(category);
    }
}
