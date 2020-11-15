package com.redd4ford.steam.model.entity;

import com.redd4ford.steam.model.annotation.Column;
import com.redd4ford.steam.model.annotation.Id;
import com.redd4ford.steam.model.annotation.Table;
import java.util.Objects;

@Table(name = "game")
public class Game {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "publisher_id")
  private Integer publisherId;

  @Column(name = "title")
  private String title;

  @Column(name = "rating")
  private Integer rating;

  @Column(name = "release_date")
  private String releaseDate;

  @Column(name = "price_in_uah")
  private Integer priceInUah;

  public Game(Integer id, Integer publisherId, String title, Integer rating, String releaseDate,
              Integer priceInUah) {
    this.id = id;
    this.publisherId = publisherId;
    this.title = title;
    this.rating = rating;
    this.releaseDate = releaseDate;
    this.priceInUah = priceInUah;
  }

  public Game(Integer publisherId, String title, Integer rating, String releaseDate,
              Integer priceInUah) {
    this(-1, publisherId, title, rating, releaseDate, priceInUah);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Game game = (Game) o;
    return id.equals(game.id)
        && publisherId.equals(game.publisherId)
        && title.equals(game.title)
        && Objects.equals(rating, game.rating)
        && Objects.equals(releaseDate, game.releaseDate)
        && priceInUah.equals(game.priceInUah);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, publisherId, title, rating, releaseDate, priceInUah);
  }

  @Override
  public String toString() {
    return "Game{"
        + "id=" + id + ", "
        + "publisherId=" + publisherId + ", "
        + "title='" + title + "', "
        + "rating=" + rating + ", "
        + "releaseDate='" + releaseDate + "', "
        + "priceInUah=" + priceInUah
        + "};";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(Integer publisherId) {
    this.publisherId = publisherId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Integer getPriceInUah() {
    return priceInUah;
  }

  public void setPriceInUah(Integer priceInUah) {
    this.priceInUah = priceInUah;
  }

}
