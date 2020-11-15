package com.redd4ford.steam.model.dao;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import com.redd4ford.steam.model.entity.AccountProtectedData;
import com.redd4ford.steam.util.DatabaseConnector;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGenericDaoImpl<E> implements AbstractGenericDao<E> {

  private static final String getAllTemplate = "select * from steam.tableName";
  private static final String getOneTemplate = getAllTemplate + " where idField = idValue";
  private static final String createTemplate = "insert into steam.tableName valuesOrder values "
      + "inputValues";
  private static final String updateTemplate = "update steam.tableName set inputValues where "
      + "idField = idValue";
  private static final String deleteTemplate = "delete from steam.tableName where "
      + "idField = idValue";

  private final Class<E> currentClass;
  private String getAllQuery;
  private String getOneQuery;
  private String createQuery;
  private String updateQuery;
  private String deleteQuery;

  public AbstractGenericDaoImpl(Class<E> currentClass) {
    this.currentClass = currentClass;
    try {
      this.getAllQuery = this.setQuery(getAllTemplate);
      this.getOneQuery = this.setQuery(getOneTemplate);
      this.createQuery = this.setQuery(createTemplate);
      this.updateQuery = this.setQuery(updateTemplate);
      this.deleteQuery = this.setQuery(deleteTemplate);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<E> findAll() throws SQLException {
    List<E> entities = new ArrayList<>();
    System.out.println("[SQL] " + getAllQuery);
    try (Statement statement = DatabaseConnector.getConnection().createStatement()) {
      ResultSet resultSet = statement.executeQuery(getAllQuery);
      while (resultSet.next()) {
        entities.add(mapResultSetToObject(resultSet));
      }
    }
    return entities;
  }

  @Override
  public E findOne(Integer id) throws SQLException {
    E entity = null;
    String currentFindOne = getOneQuery.replace("idValue", id.toString());
    System.out.println("[SQL] " + currentFindOne);
    try (PreparedStatement statement =
             DatabaseConnector.getConnection().prepareStatement(currentFindOne)) {
      try (ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          entity = mapResultSetToObject(resultSet);
        }
      }
    }
    return entity;
  }

  @Override
  public void create(E entity) throws SQLException {
    System.out.println("got into create");
    String createQuery = null;
    Connection connection = DatabaseConnector.getConnection();
    try {
      createQuery = setCreateQuery(entity);
      System.out.println("[SQL] " + createQuery);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try (PreparedStatement statement = connection.prepareStatement(createQuery)) {
      statement.executeUpdate();
    }
    connection.close();
    System.out.println("closed");
  }

  @Override
  public void update(Integer id, E entity) throws SQLException {
    String currentUpdate = null;
    Connection connection = DatabaseConnector.getConnection();
    try {
      currentUpdate = setUpdateQuery(id, entity);
      System.out.println("[SQL] " + currentUpdate);
    } catch (IllegalArgumentException | IllegalAccessException e) {
      e.printStackTrace();
    }
    try (PreparedStatement statement = connection.prepareStatement(currentUpdate)) {
      statement.executeUpdate();
    }
    connection.close();
  }

  @Override
  public void delete(Integer id) throws SQLException {
    String currentDelete = deleteQuery.replace("idValue", String.valueOf(id));
    System.out.println("[SQL] " + currentDelete);
    try (PreparedStatement statement = DatabaseConnector.getConnection()
        .prepareStatement(currentDelete)) {
      statement.executeUpdate();
    }
  }

  @Override
  public abstract E mapResultSetToObject(ResultSet resultSet) throws SQLException;

  private String setQuery(String template)
      throws IllegalArgumentException {
    Field[] fields = currentClass.getDeclaredFields();
    String tableName = currentClass.getAnnotation(Table.class).name();
    String query = template.replace("tableName", tableName);
    System.out.println(template);
    for (Field field : fields) {
      if (field.isAnnotationPresent(Id.class)) {
        String idFieldName = field.getAnnotation(Column.class).name();
        return query.replace("idField", idFieldName);
      }
    }
    return query;
  }

  private String setCreateQuery(E entity)
      throws IllegalArgumentException, IllegalAccessException {
    StringBuffer valuesOrder = new StringBuffer().append('(');
    StringBuffer valuesPlaceholder = new StringBuffer().append('(');
    Field[] fields = entity.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(Id.class)) {
        if (!field.getAnnotation(Column.class).name().equals("account_id")) {
          continue;
        }
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
    valuesOrder.replace(valuesOrder.length() - 2, valuesOrder.length(), ")");
    valuesPlaceholder.replace(valuesPlaceholder.length() - 2, valuesPlaceholder.length(), ")");
    return createQuery.replace("valuesOrder", valuesOrder).replace("inputValues",
        valuesPlaceholder);
  }

  private String setUpdateQuery(Integer id, E entity)
      throws IllegalArgumentException, IllegalAccessException {
    StringBuffer inputValues = new StringBuffer();
    String currentUpdate = null;
    Field[] fields = entity.getClass().getDeclaredFields();

    for (Field field : fields) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(Id.class)) {
        currentUpdate = updateQuery.replace("idValue", id.toString());
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
    inputValues.replace(inputValues.length() - 2, inputValues.length(), "");
    assert currentUpdate != null;
    return currentUpdate.replace("inputValues", inputValues);
  }

}
