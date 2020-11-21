package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Account;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class AccountDaoImpl extends AbstractGenericDaoImpl<Account> {

  public AccountDaoImpl() {
    super(Account.class);
  }

  @SuppressWarnings("unchecked")
  public List<Account> findByCountryId(Session session, Integer countryId) {
    List<Account> accountsByCountryId = new ArrayList<>();

    try {
      session.beginTransaction();
      System.out.println("[SQL] select * from account where country_id = " + countryId);
      accountsByCountryId = session.createQuery("from Account where countryId = " + countryId)
          .getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return accountsByCountryId;
  }

}
