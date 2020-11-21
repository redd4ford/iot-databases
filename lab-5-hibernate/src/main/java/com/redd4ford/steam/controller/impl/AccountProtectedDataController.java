package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.AccountProtectedDataDaoImpl;
import com.redd4ford.steam.model.entity.AccountProtectedData;
import org.hibernate.Session;

public class AccountProtectedDataController
    extends AbstractGenericControllerImpl<AccountProtectedData> {

  public AccountProtectedDataController(Session session) {
    super(session);
  }

  @Override
  public AbstractGenericDaoImpl<AccountProtectedData> getDao() {
    return new AccountProtectedDataDaoImpl();
  }

}
