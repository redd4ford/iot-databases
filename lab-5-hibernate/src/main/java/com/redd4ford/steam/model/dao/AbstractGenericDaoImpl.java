package com.redd4ford.steam.model.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.Session;

public abstract class AbstractGenericDaoImpl<E> implements AbstractGenericDao<E> {

  private final Class<E> currentClass;
  private final String tableName;

  public AbstractGenericDaoImpl(Class<E> currentClass) {
    this.currentClass = currentClass;
    this.tableName = currentClass.getAnnotation(Table.class).name();
  }

  @Override
  @SuppressWarnings("unchecked")
  public Collection<E> findAll(Session session) {
    List<E> entities = new ArrayList<>();

    try {
      session.beginTransaction();
      System.out.println("[SQL] select * from " + tableName);
      entities = session.createQuery("from " + currentClass.getName()).getResultList();
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return entities;
  }

  @Override
  public E findOne(Session session, Integer id) {
    E entity = null;

    try {
      session.beginTransaction();
      System.out.println("[SQL] select * from " + tableName + " where " + getIdFieldName()
          + " = " + id.toString());
      entity = session.get(currentClass, id);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return entity;
  }

  @Override
  public void create(Session session, E entity) {
    try {
      session.beginTransaction();
      System.out.println("[SQL] " + getCreateQuery(entity));
      session.save(entity);
      session.getTransaction().commit();
      if (session.isOpen()) {
        session.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update(Session session, Integer id, E entity) {
    try {
      session.beginTransaction();
      System.out.println("[SQL] " + getUpdateQuery(id, entity));
      session.update(entity);
      session.getTransaction().commit();
      if (session.isOpen()) {
        session.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Session session, Integer id) {
    try {
      session.beginTransaction();
      System.out.println("[SQL] delete from steam." + tableName + " where id = " + id.toString());
      E entity = session.get(currentClass, id);
      if (entity != null) {
        session.delete(entity);
      }
      session.getTransaction().commit();
      if (session.isOpen()) {
        session.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String getIdFieldName() {
    Field[] fields = currentClass.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(Id.class)) {
        return field.getAnnotation(Column.class).name();
      }
    }
    return null;
  }

  private String getCreateQuery(E entity)
      throws IllegalArgumentException, IllegalAccessException {
    StringBuffer valuesOrder = new StringBuffer().append('(');
    StringBuffer valuesPlaceholder = new StringBuffer().append('(');

    Field[] fields = entity.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(Id.class)
          && !field.getAnnotation(Column.class).name().equals("account_id")) {
        continue;
      }
      if (field.isAnnotationPresent(ManyToMany.class)) {
        continue;
      }
      valuesOrder.append(field.getAnnotation(Column.class).name()).append(", ");
      if (field.get(entity) instanceof String) {
        valuesPlaceholder.append("'").append(field.get(entity))
            .append("', ");
      } else {
        valuesPlaceholder.append(field.get(entity))
            .append(", ");
      }
    }
    String createQuery = "insert into " + tableName + "valuesOrder values inputValues";

    valuesOrder.replace(valuesOrder.length() - 2, valuesOrder.length(), ")");
    valuesPlaceholder.replace(valuesPlaceholder.length() - 2, valuesPlaceholder.length(), ")");
    return createQuery.replace("valuesOrder", valuesOrder).replace("inputValues",
        valuesPlaceholder);
  }

  private String getUpdateQuery(Integer id, E entity)
      throws IllegalArgumentException, IllegalAccessException {
    StringBuffer inputValues = new StringBuffer();
    Field[] fields = entity.getClass().getDeclaredFields();

    for (Field field : fields) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(Id.class)) {
        continue;
      }
      if (field.get(entity) instanceof String) {
        inputValues.append(field.getAnnotation(Column.class).name()).append("='")
            .append(field.get(entity)).append("', ");
      } else {
        inputValues.append(field.getAnnotation(Column.class).name()).append("=")
            .append(field.get(entity)).append(", ");
      }
    }
    String updateQuery = "update " + tableName + " set inputValues where "
        + getIdFieldName() + " = " + id.toString();

    inputValues.replace(inputValues.length() - 2, inputValues.length(), "");
    return updateQuery.replace("inputValues", inputValues);
  }

}
