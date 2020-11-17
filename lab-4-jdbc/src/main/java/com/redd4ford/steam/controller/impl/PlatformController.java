package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.dao.impl.PlatformDaoImpl;
import com.redd4ford.steam.model.entity.Platform;

public class PlatformController
    extends AbstractGenericControllerImpl<Platform> {

  @Override
  public AbstractGenericDaoImpl<Platform> getDao() {
    return new PlatformDaoImpl();
  }

}
