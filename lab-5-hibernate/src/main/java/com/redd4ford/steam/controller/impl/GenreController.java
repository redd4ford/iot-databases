package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.GenreDaoImpl;
import com.redd4ford.steam.model.entity.Genre;

public class GenreController
    extends AbstractGenericControllerImpl<Genre> {

  @Override
  public AbstractGenericDaoImpl<Genre> getDao() {
    return new GenreDaoImpl();
  }

}
