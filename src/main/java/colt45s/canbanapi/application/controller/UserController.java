package colt45s.canbanapi.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import colt45s.canbanapi.domain.User;
import colt45s.canbanapi.domain.service.UserService;

/**
 * UserController
 */
@RestController
@RequestMapping(path = "/api/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> getUsers() {
    return this.userService.findAll();
  }

}