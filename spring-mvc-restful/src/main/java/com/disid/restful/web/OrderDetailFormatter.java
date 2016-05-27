package com.disid.restful.web;
import com.disid.restful.model.OrderDetail;
import com.disid.restful.service.api.OrderDetailService;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;

@RooFormatter(entity = OrderDetail.class, service = OrderDetailService.class)
public class OrderDetailFormatter {
}
