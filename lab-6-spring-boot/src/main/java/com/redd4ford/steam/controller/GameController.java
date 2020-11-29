package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.Game;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.GameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/games")
@RestController
public class GameController extends AbstractController<Game, Integer> {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @Override
  protected AbstractService<Game, Integer> getService() {
    return gameService;
  }

}
