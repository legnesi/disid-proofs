package com.disid.restful.web.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.disid.restful.service.api.CustomerOrderService;
import com.disid.restful.service.api.CustomerService;

@Controller
@RequestMapping("/customers/search")
public class CustomersSearchController {

    public CustomerOrderService customerOrderService;

    public CustomerService customerService;

    @Autowired
    public CustomersSearchController(CustomerService customerService, CustomerOrderService customerOrderService) {
        this.customerService = customerService;
        this.customerOrderService = customerOrderService;
    }

}
