package com.redd4ford.steam.controller;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import java.util.List;
import org.hibernate.Session;

public abstract class AbstractGenericControllerImpl<E>
    implements AbstractGenericController<E> {

  public abstract AbstractGenericDaoImpl<E> getDao();

  public final Session session;

  public AbstractGenericControllerImpl(Session session) {
    this.session = session;
  }

  @Override
  public List<E> findAll() {
    return (List<E>) getDao().findAll(session);
  }

  @Override
  public E findOne(Integer id) {
    return getDao().findOne(session, id);
  }

  @Override
  public void create(E object) {
    getDao().create(session, object);
  }

  @Override
  public void update(Integer id, E object) {
    getDao().update(session, id, object);
  }

  @Override
  public void delete(Integer id) {
    getDao().delete(session, id);
  }

}
