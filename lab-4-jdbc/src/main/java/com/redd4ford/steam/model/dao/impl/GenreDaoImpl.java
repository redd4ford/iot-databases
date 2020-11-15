package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDaoImpl extends AbstractGenericDaoImpl<Genre> {

  public GenreDaoImpl() {
    super(Genre.class);
  }

  @Override
  public Genre mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Genre(
        resultSet.getInt(1),
        resultSet.getString("name")
    );
  }

}
