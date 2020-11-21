package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.CountryDaoImpl;
import com.redd4ford.steam.model.entity.Country;
import org.hibernate.Session;

public class CountryController
    extends AbstractGenericControllerImpl<Country> {

  public CountryController(Session session) {
    super(session);
  }

  @Override
  public AbstractGenericDaoImpl<Country> getDao() {
    return new CountryDaoImpl();
  }

}
