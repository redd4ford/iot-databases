package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.SupportedBrowser;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupportedBrowserDaoImpl extends AbstractGenericDaoImpl<SupportedBrowser> {

  public SupportedBrowserDaoImpl() {
    super(SupportedBrowser.class);
  }

  @Override
  public SupportedBrowser mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new SupportedBrowser(
        resultSet.getInt(1),
        resultSet.getString("name"),
        resultSet.getString("version")
    );
  }

}
