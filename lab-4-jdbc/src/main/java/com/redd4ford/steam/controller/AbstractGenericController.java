package com.redd4ford.steam.controller;

import com.redd4ford.steam.model.dao.AbstractGenericDaoImpl;
import java.sql.SQLException;
import java.util.List;

public interface AbstractGenericController<E> {

  AbstractGenericDaoImpl<E> getDao();

  List<E> findAll() throws SQLException;

  E findOne(Integer id) throws SQLException;

  void create(E entity) throws SQLException;

  void update(Integer id, E entity) throws SQLException;

  void delete(Integer id) throws SQLException;

}
