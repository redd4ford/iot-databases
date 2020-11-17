package com.redd4ford.steam.controller;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractGenericControllerImpl<E>
    implements AbstractGenericController<E> {

  public abstract AbstractGenericDaoImpl<E> getDao();

  @Override
  public List<E> findAll() throws SQLException {
    return getDao().findAll();
  }

  @Override
  public E findOne(Integer id) throws SQLException {
    return getDao().findOne(id);
  }

  @Override
  public void create(E object) throws SQLException {
    getDao().create(object);
  }

  @Override
  public void update(Integer id, E object) throws SQLException {
    getDao().update(id, object);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    getDao().delete(id);
  }

}
