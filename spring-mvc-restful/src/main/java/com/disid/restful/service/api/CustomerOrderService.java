package com.disid.restful.service.api;

import java.util.Set;

import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.disid.restful.model.CustomerOrder;

@RooService(entity = CustomerOrder.class)
public interface CustomerOrderService {

    void delete(CustomerOrder customerOrder);

    Set<CustomerOrder> findByIdIn(Long[] orders);
}
