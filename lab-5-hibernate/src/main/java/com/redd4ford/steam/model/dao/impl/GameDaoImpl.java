package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Game;
import com.redd4ford.steam.model.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class GameDaoImpl extends AbstractGenericDaoImpl<Game> {

  public GameDaoImpl() {
    super(Game.class);
  }

  @SuppressWarnings("unchecked")
  public List<Game> findByPublisherId(Integer publisherId) {
    List<Game> gamesByPublisherId = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      gamesByPublisherId = session.createQuery("from Game where publisher.id = " + publisherId)
          .getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return gamesByPublisherId;
  }

  @SuppressWarnings("unchecked")
  public void findGenresForGames() {
    try (Session session = sessionFactory.getCurrentSession()) {
      List<Game> games = session.createQuery("from Game").getResultList();
      for (Game game : games) {
        System.out.println(game);
        for (Genre genre : game.getGenres()) {
          System.out.println(genre);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
