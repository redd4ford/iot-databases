package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.Account;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/accounts")
@RestController
public class AccountController extends AbstractController<Account, Integer> {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  protected AbstractService<Account, Integer> getService() {
    return accountService;
  }

}
