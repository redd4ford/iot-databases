package com.redd4ford.steam.model.entity;

import java.util.Objects;
import javax.persistence.*;

@Table(name = "account")
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  private Country country;

  @Column(name = "account_name")
  private String accountName;

  @Column(name = "level")
  private Integer level;

  @Column(name = "is_online")
  private Integer isOnline;

  public Account(Integer id, Country country, String accountName, Integer level,
                 Integer isOnline) {
    this.id = id;
    this.country = country;
    this.accountName = accountName;
    this.level = level;
    this.isOnline = isOnline;
  }

  public Account() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return id.equals(account.id)
        && country.equals(account.country)
        && accountName.equals(account.accountName)
        && level.equals(account.level)
        && isOnline.equals(account.isOnline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, country, accountName, level, isOnline);
  }

  @Override
  public String toString() {
    return "Account{"
        + "id=" + id + ", "
        + "countryId=" + country.getId() + ", "
        + "accountName='" + accountName + "', "
        + "level=" + level + ", "
        + "isOnline=" + isOnline
        + "};";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getIsOnline() {
    return isOnline;
  }

  public void setIsOnline(Integer isOnline) {
    this.isOnline = isOnline;
  }

}
