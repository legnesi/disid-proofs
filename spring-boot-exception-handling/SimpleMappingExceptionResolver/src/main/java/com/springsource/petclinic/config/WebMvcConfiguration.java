package com.springsource.petclinic.config;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooWebMvcConfiguration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.springsource.petclinic.web.exceptions.CauseAdviceSimpleMappingExceptionResolver;

@RooWebMvcConfiguration
public class WebMvcConfiguration {
	
	// THIS IS NOT WORKING. Seems like SimpleMappingExceptionResolver is not 
	// catching root cause exception
    /*@Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver =
              new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty("EntityResultNotFoundException", "errors/404");
        
        resolver.setExceptionMappings(mappings);
        return resolver;
    }*/
	
	// Is necessary to extend default implementation of SimpleMappingExceptionResolver
	// to check root cause too. Also, is necessary to set order to this new resolver to
	// be able to load it as the first resolver.
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver =
              new CauseAdviceSimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty("EntityResultNotFoundException", "errors/404");
        
        resolver.setExceptionMappings(mappings);
        resolver.setOrder(-1);
        return resolver;
    }


}
