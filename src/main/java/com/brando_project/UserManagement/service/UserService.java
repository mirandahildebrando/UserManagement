package com.brando_project.UserManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brando_project.UserManagement.entity.User;
import com.brando_project.UserManagement.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);

    }
}
