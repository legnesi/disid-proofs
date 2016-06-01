package com.disid.restful.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import com.disid.restful.model.Customer;
import com.disid.restful.model.CustomerOrder;
import com.disid.restful.repository.CustomerRepository;
import com.disid.restful.service.api.CustomerOrderService;
import com.disid.restful.service.api.CustomerService;

@RooServiceImpl(service = CustomerService.class)
public class CustomerServiceImpl {

    private CustomerOrderService customerOrderService;

    private CustomerServiceImpl(CustomerRepository customerRepository) {
	this.customerRepository = customerRepository;
    }

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, @Lazy CustomerOrderService customerOrderService) {
	this(customerRepository);
	this.customerOrderService = customerOrderService;
    }

    public void delete(Customer customer) {
	customerRepository.delete(customer);
    }

    @Transactional
    public Customer setOrders(Customer customer, Long[] orders) {
	Set<CustomerOrder> customerOrders = updateAndGetCustomerOrders(customer, orders, true);
	customer.setOrders(customerOrders);
	return customerRepository.save(customer);
    }

    @Transactional
    public Customer addOrders(Customer customer, Long[] orders) {
	Set<CustomerOrder> customerOrders = updateAndGetCustomerOrders(customer, orders, true);
	customer.getOrders().addAll(customerOrders);
	return customerRepository.save(customer);
    }

    private Set<CustomerOrder> updateAndGetCustomerOrders(Customer customer, Long[] orders, boolean addCustomer) {
	Set<CustomerOrder> customerOrders = customerOrderService.findByIdIn(orders);
	for (CustomerOrder customerOrder : customerOrders) {
	    if (addCustomer) {
		customerOrder.setCustomer(customer);
	    } else {
		customerOrder.setCustomer(null);
	    }
	}
	List<CustomerOrder> saved = customerOrderService.save(customerOrders);
	return new HashSet<CustomerOrder>(saved);
    }

    @Transactional
    public Customer deleteOrders(Customer customer, Long[] orders) {
	Set<CustomerOrder> customerOrders = updateAndGetCustomerOrders(customer, orders, false);
	customer.getOrders().removeAll(customerOrders);
	return customerRepository.save(customer);
    }
}
