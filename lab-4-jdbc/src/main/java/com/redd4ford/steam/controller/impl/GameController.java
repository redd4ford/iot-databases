package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.GameDaoImpl;
import com.redd4ford.steam.model.entity.Game;

public class GameController
    extends AbstractGenericControllerImpl<Game, GameDaoImpl> {

  public GameController() {
    super(GameDaoImpl.class);
  }

}
