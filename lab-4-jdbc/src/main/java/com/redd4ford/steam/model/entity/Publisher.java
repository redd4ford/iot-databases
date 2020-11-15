package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "publisher")
public class Publisher {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "country_id")
  private Integer countryId;

  public Publisher(Integer id, String name, Integer countryId) {
    this.id = id;
    this.name = name;
    this.countryId = countryId;
  }

  public Publisher(String name, Integer countryId) {
    this(-1, name, countryId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Publisher publisher = (Publisher) o;
    return id.equals(publisher.id)
        && name.equals(publisher.name)
        && countryId.equals(publisher.countryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, countryId);
  }

  @Override
  public String toString() {
    return "Publisher{"
        + "id=" + id + ", "
        + "name='" + name + "', "
        + "countryId=" + countryId
        + "};";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

}
