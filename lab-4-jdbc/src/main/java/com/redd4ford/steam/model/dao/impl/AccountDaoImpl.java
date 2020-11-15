package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Account;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl extends AbstractGenericDaoImpl<Account> {

  public AccountDaoImpl() {
    super(Account.class);
  }

  @Override
  public Account mapResultSetToObject(ResultSet resultSet) throws SQLException {
    return new Account(
        resultSet.getInt(1),
        resultSet.getInt("country_id"),
        resultSet.getString("account_name"),
        resultSet.getInt("level"),
        resultSet.getInt("is_online")
    );
  }

}
