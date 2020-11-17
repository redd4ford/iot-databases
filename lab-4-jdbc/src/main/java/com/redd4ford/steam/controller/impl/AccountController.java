package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.AccountDaoImpl;
import com.redd4ford.steam.model.entity.Account;

public class AccountController
    extends AbstractGenericControllerImpl<Account> {

  @Override
  public AbstractGenericDaoImpl<Account> getDao() {
    return new AccountDaoImpl();
  }

}
