package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.AccountProtectedData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountProtectedDataDaoImpl extends AbstractGenericDaoImpl<AccountProtectedData> {

  public AccountProtectedDataDaoImpl() {
    super(AccountProtectedData.class);
  }

  @Override
  public AccountProtectedData mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new AccountProtectedData(
        resultSet.getInt(1),
        resultSet.getString("password"),
        resultSet.getString("email")
    );
  }

}
