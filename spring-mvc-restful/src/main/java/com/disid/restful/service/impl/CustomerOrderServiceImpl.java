package com.disid.restful.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;

import com.disid.restful.model.CustomerOrder;
import com.disid.restful.model.OrderDetail;
import com.disid.restful.model.OrderDetailPK;
import com.disid.restful.repository.CustomerOrderRepository;
import com.disid.restful.service.api.CustomerOrderService;
import com.disid.restful.service.api.OrderDetailService;

@RooServiceImpl(service = CustomerOrderService.class)
public class CustomerOrderServiceImpl {

    private OrderDetailService orderDetailService;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository) {
	this.customerOrderRepository = customerOrderRepository;
    }

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository,
	    OrderDetailService orderDetailService) {
	this(customerOrderRepository);
	this.orderDetailService = orderDetailService;
    }

    public void delete(CustomerOrder customerOrder) {
	customerOrderRepository.delete(customerOrder);
    }

    public Set<CustomerOrder> findByIdIn(Long[] orders) {
	return customerOrderRepository.findByIdIn(orders);
    }

    public CustomerOrder setDetails(CustomerOrder customerOrder, Collection<OrderDetail> details) {
	Collection<OrderDetail> savedDetails = updateAndCreateDetails(customerOrder, details, 0);
	customerOrder.setDetails(new HashSet<OrderDetail>(savedDetails));
	return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder addDetails(CustomerOrder customerOrder, Collection<OrderDetail> details) {
	Set<OrderDetail> currentDetails = customerOrder.getDetails();
	Collection<OrderDetail> savedDetails = updateAndCreateDetails(customerOrder, details,
		currentDetails.size() - 1);
	currentDetails.addAll(savedDetails);
	return customerOrderRepository.save(customerOrder);
    }

    private Collection<OrderDetail> updateAndCreateDetails(CustomerOrder customerOrder, Collection<OrderDetail> details,
	    int initialPos) {
	for (OrderDetail orderDetail : details) {
	    OrderDetailPK pk = new OrderDetailPK();
	    pk.setId(initialPos++);
	    pk.setCustomerOrderId(customerOrder.getId());
	    orderDetail.setId(pk);
	    orderDetail.setCustomerOrder(customerOrder);
	}
	return orderDetailService.save(details);
    }

    public CustomerOrder deleteDetails(CustomerOrder customerOrder, Collection<OrderDetail> details) {
	customerOrder.getDetails().removeAll(details);
	for (OrderDetail orderDetail : details) {
	    orderDetailService.delete(orderDetail);
	}
	return customerOrderRepository.save(customerOrder);
    }
}
