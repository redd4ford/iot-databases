package com.redd4ford.steam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
public class MainController {

  @RequestMapping(method = RequestMethod.GET, value = "healthcheck")
  public @ResponseBody ResponseEntity<Void> getAll() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
