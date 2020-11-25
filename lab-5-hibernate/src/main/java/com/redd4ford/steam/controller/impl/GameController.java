package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.GameDaoImpl;
import com.redd4ford.steam.model.entity.Game;
import java.util.List;

public class GameController
    extends AbstractGenericControllerImpl<Game> {

  private final GameDaoImpl gameDao = new GameDaoImpl();

  @Override
  public AbstractGenericDaoImpl<Game> getDao() {
    return gameDao;
  }

  public List<Game> findByPublisher(Integer id) {
    return gameDao.findByPublisherId(id);
  }

  public void findGenres() {
    gameDao.findGenresForGames();
  }

}
