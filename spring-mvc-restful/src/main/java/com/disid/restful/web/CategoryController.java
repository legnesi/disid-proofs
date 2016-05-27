package com.disid.restful.web;
import com.disid.restful.model.Category;
import com.disid.restful.service.api.CategoryService;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

@RooController(path = "/categories", entity = Category.class, service = CategoryService.class)
@RooJSON
@RooThymeleaf
public class CategoryController {
}
