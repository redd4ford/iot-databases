package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.Genre;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/genres")
@RestController
public class GenreController extends AbstractController<Genre, Integer> {

  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @Override
  protected AbstractService<Genre, Integer> getService() {
    return genreService;
  }

}
