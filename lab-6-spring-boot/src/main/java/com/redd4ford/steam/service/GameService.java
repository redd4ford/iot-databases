package com.redd4ford.steam.service;

import com.redd4ford.steam.domain.Game;
import com.redd4ford.steam.repository.GameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService extends AbstractService<Game, Integer> {

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  @Override
  protected JpaRepository<Game, Integer> getRepository() {
    return gameRepository;
  }

}
