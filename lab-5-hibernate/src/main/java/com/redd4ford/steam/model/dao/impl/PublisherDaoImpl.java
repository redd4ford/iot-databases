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
  public List<Publisher> findByCountryId(Integer countryId) {
    List<Publisher> publishersByCountryId = new ArrayList<>();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.beginTransaction();
      publishersByCountryId = session.createQuery("from Publisher where country.id = " + countryId)
          .getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return publishersByCountryId;
  }

}
