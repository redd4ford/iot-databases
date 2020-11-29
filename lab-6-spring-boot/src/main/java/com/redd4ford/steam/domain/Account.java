package com.redd4ford.steam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "account")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
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

}
