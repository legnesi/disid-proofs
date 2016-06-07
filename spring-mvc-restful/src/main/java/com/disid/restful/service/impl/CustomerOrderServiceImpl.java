package com.disid.restful.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CustomerOrder addToDetails(CustomerOrder customerOrder, OrderDetail... details) {
	Set<OrderDetail> currentDetails = customerOrder.getDetails();

	int initialPos = currentDetails.size();
	for (OrderDetail orderDetail : details) {
	    OrderDetailPK pk = new OrderDetailPK();
	    pk.setId(initialPos++);
	    pk.setCustomerOrderId(customerOrder.getId());
	    orderDetail.setId(pk);
	    orderDetail.setCustomerOrder(customerOrder);
	    OrderDetail savedDetail = orderDetailService.save(orderDetail);
	    currentDetails.add(savedDetail);
	}

	return customerOrderRepository.save(customerOrder);
    }

    @Transactional
    public CustomerOrder deleteFromDetails(CustomerOrder customerOrder, OrderDetail... details) {
	for (OrderDetail orderDetail : details) {
	    customerOrder.getDetails().remove(orderDetail);
	    orderDetailService.delete(orderDetail);
	}
	return customerOrderRepository.save(customerOrder);
    }

}
