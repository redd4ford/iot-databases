package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Country;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDaoImpl extends AbstractGenericDaoImpl<Country> {

  public CountryDaoImpl() {
    super(Country.class);
  }

  @Override
  public Country mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Country(
        resultSet.getInt(1),
        resultSet.getString("name")
    );
  }

}
