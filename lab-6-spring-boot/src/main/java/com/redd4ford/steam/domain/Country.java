package com.redd4ford.steam.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "country")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
  private Set<Account> accounts;

  @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
  private Set<Publisher> publishers;

  @Override
  public String toString() {
    return "Country{"
        + "id=" + id + ", "
        + "name='" + name + "'"
        + "};";
  }

}
