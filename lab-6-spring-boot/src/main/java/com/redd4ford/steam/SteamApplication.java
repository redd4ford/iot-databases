package com.redd4ford.steam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.redd4ford.steam.*"})
@EntityScan("com.redd4ford.steam.domain")
@EnableJpaRepositories("com.redd4ford.steam.repository")
public class SteamApplication {

  public static void main(String[] args) {
    SpringApplication.run(SteamApplication.class, args);
  }

}
