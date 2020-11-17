package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.PublisherDaoImpl;
import com.redd4ford.steam.model.entity.Publisher;

public class PublisherController
    extends AbstractGenericControllerImpl<Publisher> {

  @Override
  public AbstractGenericDaoImpl<Publisher> getDao() {
    return new PublisherDaoImpl();
  }

}
