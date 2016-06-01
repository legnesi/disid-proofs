package com.disid.restful.service.impl;

import java.util.Set;

import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.CustomerOrder;
import com.disid.restful.service.api.CustomerOrderService;

@RooServiceImpl(service = CustomerOrderService.class)
public class CustomerOrderServiceImpl {

    public void delete(CustomerOrder customerOrder) {
	customerOrderRepository.delete(customerOrder);
    }

    public Set<CustomerOrder> findByIdIn(Long[] orders) {
	return customerOrderRepository.findByIdIn(orders);
    }
}
