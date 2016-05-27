package com.disid.restful.web;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.disid.restful.model.OrderDetail;
import com.disid.restful.model.OrderDetailPK;
import com.disid.restful.service.api.OrderDetailService;

@RooController(path = "/orderdetails", entity = OrderDetail.class, service = OrderDetailService.class)
@RooJSON
@RooThymeleaf
public class OrderDetailController {

    public HttpHeaders populateHeaders(Long id) {
	// Nothing to do
	return null;
    }

    public HttpHeaders populateHeaders(OrderDetailPK id) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("/orderdetails/{id}").build();
        URI uri = uriComponents.expand(id).encode().toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uri);
        return responseHeaders;
    }
}
