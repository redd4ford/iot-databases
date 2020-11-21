package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Game;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class GameDaoImpl extends AbstractGenericDaoImpl<Game> {

  public GameDaoImpl() {
    super(Game.class);
  }

  @SuppressWarnings("unchecked")
  public List<Game> findByPublisherId(Session session, Integer publisherId) {
    List<Game> gamesByPublisherId = new ArrayList<>();

    try {
      session.beginTransaction();
      System.out.println("[SQL] select * from game where publisher_id = " + publisherId);
      gamesByPublisherId = session.createQuery("from Game where publisherId = " + publisherId)
          .getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return gamesByPublisherId;
  }

}
