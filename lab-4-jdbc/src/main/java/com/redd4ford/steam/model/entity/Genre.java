package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "genre")
public class Genre {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  public Genre(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre(String name) {
    this(-1, name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Genre genre = (Genre) o;
    return id.equals(genre.id)
        && name.equals(genre.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Genre{"
        + "id=" + id + ", "
        + "name='" + name + "'"
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

}
