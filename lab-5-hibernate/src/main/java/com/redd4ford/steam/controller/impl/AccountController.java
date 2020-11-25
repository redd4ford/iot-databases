package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.AccountDaoImpl;
import com.redd4ford.steam.model.entity.Account;
import java.util.List;

public class AccountController
    extends AbstractGenericControllerImpl<Account> {

  private final AccountDaoImpl accountDao = new AccountDaoImpl();

  @Override
  public AbstractGenericDaoImpl<Account> getDao() {
    return accountDao;
  }

  public List<Account> findByCountry(Integer id) {
    return accountDao.findByCountryId(id);
  }

}
