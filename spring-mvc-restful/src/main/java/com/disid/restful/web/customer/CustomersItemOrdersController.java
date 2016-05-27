package com.disid.restful.web.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.disid.restful.datatables.DatatablesData;
import com.disid.restful.model.Customer;
import com.disid.restful.model.CustomerOrder;
import com.disid.restful.repository.GlobalSearch;
import com.disid.restful.service.api.CustomerOrderService;
import com.disid.restful.service.api.CustomerService;

@Controller
@RequestMapping("/customers/{customer}/customerorders")
public class CustomersItemOrdersController {

    public CustomerOrderService customerOrderService;

    public CustomerService customerService;

    @Autowired
    public CustomersItemOrdersController(CustomerService customerService, CustomerOrderService customerOrderService) {
        this.customerService = customerService;
        this.customerOrderService = customerOrderService;
    }

    @ModelAttribute
    public Customer getCustomer(@PathVariable("customer") Long id) {
	return customerService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<CustomerOrder> listCustomerOrder(@PathVariable("customer") Customer customer, GlobalSearch search,
	    Pageable pageable) {
	Page<CustomerOrder> customerOrder = customerOrderService.findAllByCustomer(customer, search, pageable);
        return customerOrder;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/vnd.datatables+json")
    @ResponseBody
    public DatatablesData<CustomerOrder> listCustomerOrder(@PathVariable("customer") Customer customer,
	    GlobalSearch search, Pageable pageable, @RequestParam("draw") Integer draw) {
	Page<CustomerOrder> customerOrder = listCustomerOrder(customer, search, pageable);
	long allAvailableCustomerOrderDetails = customerOrderService.countByCustomerId(customer.getId());
        return new DatatablesData<CustomerOrder>(customerOrder, allAvailableCustomerOrderDetails, draw);
    }

}
