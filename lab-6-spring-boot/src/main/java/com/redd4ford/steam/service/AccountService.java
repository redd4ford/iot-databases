package com.redd4ford.steam.service;

import com.redd4ford.steam.domain.Account;
import com.redd4ford.steam.repository.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Account, Integer> {

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  protected JpaRepository<Account, Integer> getRepository() {
    return accountRepository;
  }

}
