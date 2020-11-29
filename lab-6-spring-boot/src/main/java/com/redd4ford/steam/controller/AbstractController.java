package com.redd4ford.steam.controller;

import com.redd4ford.steam.service.AbstractService;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class AbstractController<E, ID> {

  protected abstract AbstractService<E, ID> getService();

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<E>> getAll() {
    return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET,
      value = "/{id}")
  public @ResponseBody ResponseEntity<E> getById(@PathVariable ID id) {
    if (getService().getById(id) != null) {
      return new ResponseEntity<>(getService().getById(id), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public @ResponseBody ResponseEntity<Void> create(@RequestBody E newObject) {
    getService().create(newObject);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      value = "/{id}",
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public @ResponseBody ResponseEntity<E> update(@PathVariable ID id, @RequestBody E object) {
    if (getService().getById(id) != null) {
      getService().update(id, object);
      return new ResponseEntity<>(getService().update(id, object), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(method = RequestMethod.DELETE,
      value = "/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable ID id) {
    if (getService().getById(id) != null) {
      getService().deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
