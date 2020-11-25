package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.CountryDaoImpl;
import com.redd4ford.steam.model.entity.Country;

public class CountryController
    extends AbstractGenericControllerImpl<Country> {

  @Override
  public AbstractGenericDaoImpl<Country> getDao() {
    return new CountryDaoImpl();
  }

}
