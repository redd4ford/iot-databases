package com.redd4ford.steam.model.dao.impl;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import com.redd4ford.steam.model.entity.Publisher;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class PublisherDaoImpl extends AbstractGenericDaoImpl<Publisher> {

  public PublisherDaoImpl() {
    super(Publisher.class);
  }

  @SuppressWarnings("unchecked")
  public List<Publisher> findByCountryId(Session session, Integer countryId) {
    List<Publisher> publishersByCountryId = new ArrayList<>();

    try {
      session.beginTransaction();
      System.out.println("[SQL] select * from publisher where country_id = " + countryId);
      publishersByCountryId = session.createQuery("from Publisher where countryId = " + countryId)
          .getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return publishersByCountryId;
  }

}
