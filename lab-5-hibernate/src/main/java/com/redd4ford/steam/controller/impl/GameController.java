package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.GameDaoImpl;
import com.redd4ford.steam.model.entity.Game;
import java.util.List;
import org.hibernate.Session;

public class GameController
    extends AbstractGenericControllerImpl<Game> {

  private final GameDaoImpl gameDao = new GameDaoImpl();

  public GameController(Session session) {
    super(session);
  }

  @Override
  public AbstractGenericDaoImpl<Game> getDao() {
    return gameDao;
  }

  public List<Game> findByPublisher(Integer id) {
    return gameDao.findByPublisherId(session, id);
  }

  public void findGenres() {
    gameDao.findGenresForGames(session);
  }

}
