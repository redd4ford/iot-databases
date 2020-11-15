package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Platform;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatformDaoImpl extends AbstractGenericDaoImpl<Platform> {

  public PlatformDaoImpl() {
    super(Platform.class);
  }

  @Override
  public Platform mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Platform(
        resultSet.getInt(1),
        resultSet.getString("name")
    );
  }

}
