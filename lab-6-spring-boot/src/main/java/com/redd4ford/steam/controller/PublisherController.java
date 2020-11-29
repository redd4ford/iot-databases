package com.redd4ford.steam.controller;

import com.redd4ford.steam.domain.Publisher;
import com.redd4ford.steam.service.AbstractService;
import com.redd4ford.steam.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/publishers")
@RestController
public class PublisherController extends AbstractController<Publisher, Integer> {

  private final PublisherService publisherService;

  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @Override
  protected AbstractService<Publisher, Integer> getService() {
    return publisherService;
  }

}
