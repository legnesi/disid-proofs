package com.disid.restful.web;
import com.disid.restful.model.Product;
import com.disid.restful.service.api.ProductService;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

@RooController(path = "/products", entity = Product.class, service = ProductService.class)
@RooJSON
@RooThymeleaf
public class ProductController {
}
