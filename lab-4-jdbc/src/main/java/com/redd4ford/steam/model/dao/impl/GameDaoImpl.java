package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Game;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDaoImpl extends AbstractGenericDaoImpl<Game> {

  public GameDaoImpl() {
    super(Game.class);
  }

  @Override
  public Game mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Game(
        resultSet.getInt(1),
        resultSet.getInt("publisher_id"),
        resultSet.getString("title"),
        resultSet.getInt("rating"),
        resultSet.getString("release_date"),
        resultSet.getInt("price_in_uah")
    );
  }

}
