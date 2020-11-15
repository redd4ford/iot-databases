package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.GenreDaoImpl;
import com.redd4ford.steam.model.entity.Genre;

public class GenreController
    extends AbstractGenericControllerImpl<Genre, GenreDaoImpl> {

  public GenreController() {
    super(GenreDaoImpl.class);
  }

}
