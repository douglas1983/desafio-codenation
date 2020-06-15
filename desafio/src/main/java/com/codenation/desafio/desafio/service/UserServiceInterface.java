package com.codenation.desafio.desafio.service;

import java.util.List;
import java.util.Optional;

import com.codenation.desafio.desafio.entity.User;

public interface UserServiceInterface {

  public Optional<User> findById(Long id);

  public List<User> findAll();

  public User save(User user);

  public void deleleById(Long id);
}
