package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "supported_browser")
public class SupportedBrowser {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "version")
  private String version;

  public SupportedBrowser(Integer id, String name, String version) {
    this.id = id;
    this.name = name;
    this.version = version;
  }

  public SupportedBrowser(String name, String version) {
    this(-1, name, version);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SupportedBrowser that = (SupportedBrowser) o;
    return id.equals(that.id)
        && name.equals(that.name)
        && version.equals(that.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, version);
  }

  @Override
  public String toString() {
    return "SupportedBrowser{"
        + "id=" + id + ", "
        + "name='" + name + "', "
        + "version='" + version + "'"
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

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

}
