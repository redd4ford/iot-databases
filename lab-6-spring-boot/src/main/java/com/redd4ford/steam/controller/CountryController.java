package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.Country;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/countries")
@RestController
public class CountryController extends AbstractController<Country, Integer> {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @Override
  protected AbstractService<Country, Integer> getService() {
    return countryService;
  }

}
