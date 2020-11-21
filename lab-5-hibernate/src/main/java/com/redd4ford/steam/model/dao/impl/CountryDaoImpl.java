package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Country;

public class CountryDaoImpl extends AbstractGenericDaoImpl<Country> {

  public CountryDaoImpl() {
    super(Country.class);
  }

}
