package com.redd4ford.steam.domain;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "publisher")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
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

  @Override
  public String toString() {
    return "Publisher{"
        + "id=" + id + ", "
        + "name='" + name + "', "
        + "countryId=" + country.getId()
        + "};";
  }

}
