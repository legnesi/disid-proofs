package com.springsource.petclinic.format;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.core.convert.ConversionService;
import org.springframework.format.Formatter;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import org.springframework.util.StringUtils;

import com.springsource.petclinic.domain.Owner;
import com.springsource.petclinic.exceptions.EntityResultNotFoundException;
import com.springsource.petclinic.service.api.OwnerService;

@RooFormatter(entity = Owner.class, service = OwnerService.class)
public class OwnerFormatter implements Formatter<Owner> {
	
    public OwnerService ownerService;
    
    public ConversionService conversionService;
	
    public OwnerFormatter(OwnerService ownerService, ConversionService conversionService) {
        this.ownerService = ownerService;
        this.conversionService = conversionService;
    }

	
    public Owner parse(String text, Locale locale) throws ParseException {
        if (text == null || !StringUtils.hasText(text)) {
            return null;
        }
        Long id = conversionService.convert(text, Long.class);
        Owner owner = ownerService.findOne(id);
        if(owner == null){
        	throw new EntityResultNotFoundException();
        }
        return owner;
    }
    
    public String print(Owner owner, Locale locale) {
    	return owner == null ? null : new StringBuilder().append(owner.getFirstName()).append(" - ").append(owner.getLastName()).append(" - ").append(owner.getAddress()).append(" - ").append(owner.getCity()).append(" - ").append(owner.getTelephone()).toString();
    }
}
