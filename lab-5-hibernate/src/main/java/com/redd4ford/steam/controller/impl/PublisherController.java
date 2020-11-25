package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.PublisherDaoImpl;
import com.redd4ford.steam.model.entity.Publisher;
import java.util.List;

public class PublisherController
    extends AbstractGenericControllerImpl<Publisher> {

  private final PublisherDaoImpl publisherDao = new PublisherDaoImpl();

  @Override
  public AbstractGenericDaoImpl<Publisher> getDao() {
    return publisherDao;
  }

  public List<Publisher> findByCountry(Integer id) {
    return publisherDao.findByCountryId(id);
  }

}
