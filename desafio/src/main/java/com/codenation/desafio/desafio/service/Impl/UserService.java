package com.codenation.desafio.desafio.service.Impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.codenation.desafio.desafio.entity.User;
import com.codenation.desafio.desafio.repository.UserRepository;
import com.codenation.desafio.desafio.service.UserServiceInterface;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface, UserDetailsService {

    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email).get();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
