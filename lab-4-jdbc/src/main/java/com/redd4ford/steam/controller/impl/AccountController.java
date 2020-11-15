package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.AccountDaoImpl;
import com.redd4ford.steam.model.entity.Account;

public class AccountController
    extends AbstractGenericControllerImpl<Account, AccountDaoImpl> {

  public AccountController() {
    super(AccountDaoImpl.class);
  }

}
