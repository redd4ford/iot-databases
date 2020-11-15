package com.redd4ford.steam.controller.impl;

import com.redd4ford.steam.controller.AbstractGenericControllerImpl;
import com.redd4ford.steam.model.dao.impl.SupportedBrowserDaoImpl;
import com.redd4ford.steam.model.entity.SupportedBrowser;

public class SupportedBrowserController
    extends AbstractGenericControllerImpl<SupportedBrowser, SupportedBrowserDaoImpl> {

  public SupportedBrowserController() {
    super(SupportedBrowserDaoImpl.class);
  }

}
