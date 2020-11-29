package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.AccountProtectedData;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.AccountProtectedDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/protected")
@RestController
public class AccountProtectedDataController
    extends AbstractController<AccountProtectedData,Integer> {

  private final AccountProtectedDataService accountProtectedDataService;

  public AccountProtectedDataController(AccountProtectedDataService accountProtectedDataService) {
    this.accountProtectedDataService = accountProtectedDataService;
  }

  @Override
  protected AbstractService<AccountProtectedData, Integer> getService() {
    return accountProtectedDataService;
  }

}
