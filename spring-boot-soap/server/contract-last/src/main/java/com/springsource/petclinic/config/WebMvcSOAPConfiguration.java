package com.springsource.petclinic.config;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import com.springsource.petclinic.service.api.OwnerService;
import com.springsource.petclinic.service.api.PetService;
import com.springsource.petclinic.web.soap.PetClinicWebService;
import com.springsource.petclinic.web.soap.PetClinicWebServiceEndpoint;

@Configuration
public class WebMvcSOAPConfiguration {

	public static final String CXF_SERVLET_URL_MAPPING = "/services/*";

	@Autowired
	private PetService petService;

	@Autowired
	private OwnerService ownerService;

	@Bean
	public ServletRegistrationBean dispatcherCXFServlet() {
		return new ServletRegistrationBean(new CXFServlet(), CXF_SERVLET_URL_MAPPING);
	}

	@Bean
	public FilterRegistrationBean openEntityManagerInViewFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new OpenEntityManagerInViewFilter());

		List<String> urlPatterns = new ArrayList<String>();
	    urlPatterns.add(CXF_SERVLET_URL_MAPPING);
	    filterRegBean.setUrlPatterns(urlPatterns);

		return filterRegBean;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public PetClinicWebService petclinicService() {
		return new PetClinicWebServiceEndpoint(this.petService, this.ownerService);
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), petclinicService());
		endpoint.publish("/PetClinicWebService");
		endpoint.setWsdlLocation("PetClinicWebService.wsdl");
		return endpoint;
	}

}
