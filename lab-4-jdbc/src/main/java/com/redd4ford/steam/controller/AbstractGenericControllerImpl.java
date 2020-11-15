package com.redd4ford.steam.controller;

import com.redd4ford.steam.model.dao.AbstractGenericDao;
import com.redd4ford.steam.util.DatabaseConnector;
import org.mozilla.javascript.Symbol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"deprecation", "unchecked"})
public abstract class AbstractGenericControllerImpl<E, D>
    implements AbstractGenericController<E> {

  private AbstractGenericDao<E> dao;

  public AbstractGenericControllerImpl(Class<D> currentClass) {
    try {
      dao = (AbstractGenericDao<E>) currentClass.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<E> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public E findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(E object) throws SQLException {
    dao.create(object);
  }

  @Override
  public void update(Integer id, E object) throws SQLException {
    dao.update(id, object);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
  }

}
