package com.codenation.desafio.service;

import java.util.List;
import java.util.Optional;

import com.codenation.desafio.dto.UserUpdateDTO;
import com.codenation.desafio.entity.User;

public interface UserServiceInterface {

  public Optional<User> findById(Long id);

  public List<User> findAll();

  public User save(User user);

  public User saveDTO(UserUpdateDTO user);

  public void deleleById(Long id);
}
