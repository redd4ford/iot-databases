package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.AccountProtectedDataDaoImpl;
import com.redd4ford.steam.model.entity.AccountProtectedData;

public class AccountProtectedDataController
    extends AbstractGenericControllerImpl<AccountProtectedData> {

  @Override
  public AbstractGenericDaoImpl<AccountProtectedData> getDao() {
    return new AccountProtectedDataDaoImpl();
  }

}
