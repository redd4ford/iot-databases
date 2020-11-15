package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "account")
public class Account {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "country_id")
  private Integer countryId;

  @Column(name = "account_name")
  private String accountName;

  @Column(name = "level")
  private Integer level;

  @Column(name = "is_online")
  private Integer isOnline;

  public Account(Integer id, Integer countryId, String accountName, Integer level,
                 Integer isOnline) {
    this.id = id;
    this.countryId = countryId;
    this.accountName = accountName;
    this.level = level;
    this.isOnline = isOnline;
  }

  public Account(Integer countryId, String accountName, Integer level, Integer isOnline) {
    this(-1, countryId, accountName, level, isOnline);
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
    return isOnline.equals(account.isOnline)
        && id.equals(account.id)
        && countryId.equals(account.countryId)
        && accountName.equals(account.accountName)
        && level.equals(account.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, countryId, accountName, level, isOnline);
  }

  @Override
  public String toString() {
    return "Account{"
        + "id=" + id + ", "
        + "countryId=" + countryId + ", "
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

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
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

  public Integer isOnline() {
    return isOnline;
  }

  public void setOnline(Integer online) {
    isOnline = online;
  }

}
