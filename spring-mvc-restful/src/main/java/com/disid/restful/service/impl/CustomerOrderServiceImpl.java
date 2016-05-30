package com.disid.restful.service.impl;

import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.CustomerOrder;
import com.disid.restful.service.api.CustomerOrderService;

@RooServiceImpl(service = CustomerOrderService.class)
public class CustomerOrderServiceImpl {

    public void delete(CustomerOrder customerOrder) {
	customerOrderRepository.delete(customerOrder);
    }
}
