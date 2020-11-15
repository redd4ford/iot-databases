package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "account_protected_data")
public class AccountProtectedData {

  @Id
  @Column(name = "account_id")
  private Integer accountId;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  public AccountProtectedData(Integer accountId, String password, String email) {
    this.accountId = accountId;
    this.password = password;
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountProtectedData that = (AccountProtectedData) o;
    return accountId.equals(that.accountId)
        && password.equals(that.password)
        && email.equals(that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, password, email);
  }

  @Override
  public String toString() {
    return "AccountProtectedData{"
        + "accountId=" + accountId + ", "
        + "password='" + password + "', "
        + "email='" + email + "'"
        + "};";
  }

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
