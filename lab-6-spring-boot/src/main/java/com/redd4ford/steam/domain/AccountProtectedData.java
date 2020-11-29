package com.redd4ford.steam.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "account_protected_data")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class AccountProtectedData implements Serializable {

  @Id
  @Column(name = "account_id")
  private Integer accountId;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @Override
  public String toString() {
    return "AccountProtectedData{"
        + "account_id=" + accountId + ", "
        + "password='" + password + ", "
        + "email='" + email + "'"
        + "};";
  }

}
