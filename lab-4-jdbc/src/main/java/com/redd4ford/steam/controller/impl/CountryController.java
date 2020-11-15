package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.CountryDaoImpl;
import com.redd4ford.steam.model.entity.Country;

public class CountryController
    extends AbstractGenericControllerImpl<Country, CountryDaoImpl> {

  public CountryController() {
    super(CountryDaoImpl.class);
  }

}
