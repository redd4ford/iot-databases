package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Publisher;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDaoImpl extends AbstractGenericDaoImpl<Publisher> {

  public PublisherDaoImpl() {
    super(Publisher.class);
  }

  @Override
  public Publisher mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Publisher(
        resultSet.getInt(1),
        resultSet.getString("name"),
        resultSet.getInt("country_id")
    );
  }

}
