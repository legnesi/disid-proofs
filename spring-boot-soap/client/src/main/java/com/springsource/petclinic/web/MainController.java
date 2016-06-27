package com.springsource.petclinic.web;

import com.cdyne.wsf.WeatherDescription;
import com.cdyne.wsf.WeatherReturn;
import com.springsource.petclinic.integration.WeatherWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleafMainController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RooThymeleafMainController
public class MainController {

  @Autowired
  private WeatherWebService weatherService;

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public String index(Model model) {
    model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());

    // Getting weather from Palo Alto, California using its ZIP code
    WeatherReturn paloAltoWeatherInfo = weatherService.getCityWeatherByZIP("94304");
    
    // If weather information from Palo Alto is available, add it to model.
    if(paloAltoWeatherInfo != null){
      
      // First, obtain more information about the weather in Palo Alto, using its ID.
      List<WeatherDescription> weatherInfoList =
          weatherService.getWeatherInformation().getWeatherDescription();
      
      for(WeatherDescription weatherInfo : weatherInfoList){
        if(weatherInfo.getWeatherID() == paloAltoWeatherInfo.getWeatherID()){
          // Add weather info image to the model
          model.addAttribute("weather_info_image", weatherInfo.getPictureURL());
          break;
        }
      }
      // Add weather info object to model
      model.addAttribute("weather_info", paloAltoWeatherInfo);
    }

    return "index";
  }
}
