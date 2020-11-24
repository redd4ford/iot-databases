package com.redd4ford.steam.model.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Table(name = "country")
@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
  private Set<Account> accounts;

  @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
  private Set<Publisher> publishers;

  public Country(Integer id, String name, Set<Account> accounts, Set<Publisher> publishers) {
    this.id = id;
    this.name = name;
    this.accounts = accounts;
    this.publishers = publishers;
  }

  public Country(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Country() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Country country = (Country) o;
    return id.equals(country.id)
        && name.equals(country.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Country{"
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

  public Set<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(Set<Account> accounts) {
    this.accounts = accounts;
  }

  public Set<Publisher> getPublishers() {
    return publishers;
  }

  public void setPublishers(Set<Publisher> publishers) {
    this.publishers = publishers;
  }

}
