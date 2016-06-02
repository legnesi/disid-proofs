package com.disid.restful.service.api;

import java.util.Collection;
import java.util.Set;

import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.disid.restful.model.CustomerOrder;
import com.disid.restful.model.OrderDetail;

@RooService(entity = CustomerOrder.class)
public interface CustomerOrderService {

    void delete(CustomerOrder customerOrder);

    Set<CustomerOrder> findByIdIn(Long[] orders);

    CustomerOrder setDetails(CustomerOrder customerOrder, Collection<OrderDetail> details);

    CustomerOrder addDetails(CustomerOrder customerOrder, Collection<OrderDetail> details);

    CustomerOrder deleteDetails(CustomerOrder customerOrder, Collection<OrderDetail> details);
}
