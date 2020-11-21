package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.AccountDaoImpl;
import com.redd4ford.steam.model.entity.Account;
import java.util.List;
import org.hibernate.Session;

public class AccountController
    extends AbstractGenericControllerImpl<Account> {

  private final AccountDaoImpl accountDao = new AccountDaoImpl();

  public AccountController(Session session) {
    super(session);
  }

  @Override
  public AbstractGenericDaoImpl<Account> getDao() {
    return accountDao;
  }

  public List<Account> findByCountry(Integer id) {
    return accountDao.findByCountryId(session, id);
  }

}
