package com.redd4ford.steam.service;

import com.redd4ford.steam.domain.Genre;
import com.redd4ford.steam.repository.GenreRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractService<Genre, Integer> {

  private final GenreRepository genreRepository;

  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  @Override
  protected JpaRepository<Genre, Integer> getRepository() {
    return genreRepository;
  }

}
