package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.PublisherDaoImpl;
import com.redd4ford.steam.model.entity.Publisher;

public class PublisherController
    extends AbstractGenericControllerImpl<Publisher, PublisherDaoImpl> {

  public PublisherController() {
    super(PublisherDaoImpl.class);
  }

}
