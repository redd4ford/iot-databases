package com.redd4ford.steam.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AbstractGenericDao<E> {

  List<E> findAll() throws SQLException;

  E findOne(Integer id) throws SQLException;

  E mapResultSetToObject(ResultSet resultSet) throws SQLException;

  void create(E object) throws SQLException;

  void update(Integer id, E object) throws SQLException;

  void delete(Integer id) throws SQLException;

}
