package com.springsource.petclinic.config;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springsource.petclinic.service.api.OwnerService;
import com.springsource.petclinic.service.api.PetService;
import com.springsource.petclinic.web.soap.PetClinicServiceImpl;
import com.springsource.petclinic.ws.PetClinicServicePortType;

@Configuration
public class WebMVCSOAPConfiguration {
  
  @Autowired
  private PetService petService;
  
  @Autowired
  private OwnerService ownerService;
  
  @Bean
  public ServletRegistrationBean dispatcherCXFServlet() {
      return new ServletRegistrationBean(new CXFServlet(), "/services/*");
  }

  @Bean(name=Bus.DEFAULT_BUS_ID)
  public SpringBus springBus() {      
      return new SpringBus();
  }
  
  @Bean
  public PetClinicServicePortType petclinicService() {
      return new PetClinicServiceImpl(this.petService, this.ownerService);
  }
  
  @Bean
  public Endpoint endpoint() {
      EndpointImpl endpoint = new EndpointImpl(springBus(), petclinicService());
      endpoint.publish("/PetClinicSoapService");
      endpoint.setWsdlLocation("PetClinic.wsdl");
      return endpoint;
  }

  
}
