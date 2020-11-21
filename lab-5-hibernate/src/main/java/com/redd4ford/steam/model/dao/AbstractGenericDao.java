package com.redd4ford.steam.model.dao;

import java.sql.SQLException;
import java.util.Collection;
import org.hibernate.Session;

public interface AbstractGenericDao<E> {

  Collection<E> findAll(Session session) throws SQLException;

  E findOne(Session session, Integer id) throws SQLException;

  void create(Session session, E object) throws SQLException;

  void update(Session session, Integer id, E object) throws SQLException;

  void delete(Session session, Integer id) throws SQLException;

}
