package com.redd4ford.steam.model.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "publisher")
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  private Country country;

  @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
  private Set<Game> games;

  public Publisher(Integer id, String name, Country country, Set<Game> games) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.games = games;
  }

  public Publisher(Integer id, String name, Country country) {
    this.id = id;
    this.name = name;
    this.country = country;
  }

  public Publisher(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Publisher() {
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
        && country.equals(publisher.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country);
  }

  @Override
  public String toString() {
    return "Publisher{"
        + "id=" + id + ", "
        + "name='" + name + "', "
        + "countryId=" + country.getId()
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

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public Set<Game> getGames() {
    return games;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }

}
