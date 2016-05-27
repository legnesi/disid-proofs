package com.disid.restful.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.Customer;
import com.disid.restful.service.api.CustomerService;

@RooServiceImpl(service = CustomerService.class)
public class CustomerServiceImpl {

    public void delete(Customer customer) {
	customerRepository.delete(customer);
    }
}
