package com.disid.restful.web;
import com.disid.restful.model.CustomerOrder;
import com.disid.restful.service.api.CustomerOrderService;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

@RooController(path = "/customerorders", entity = CustomerOrder.class, service = CustomerOrderService.class)
@RooJSON
@RooThymeleaf
public class CustomerOrderController {
}
