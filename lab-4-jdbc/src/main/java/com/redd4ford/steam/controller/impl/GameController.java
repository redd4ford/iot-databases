package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.GameDaoImpl;
import com.redd4ford.steam.model.entity.Game;

public class GameController
    extends AbstractGenericControllerImpl<Game> {

  @Override
  public AbstractGenericDaoImpl<Game> getDao() {
    return new GameDaoImpl();
  }

}
