package com.codenation.desafio.desafio.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codenation.desafio.desafio.entity.User;
import com.codenation.desafio.desafio.service.Impl.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService service;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return service.findAll();
    }

}
