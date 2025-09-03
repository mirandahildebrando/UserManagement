package com.brando_project.UserManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brando_project.UserManagement.entity.User;
import com.brando_project.UserManagement.service.UserService;

@Controller
@RequestMapping("https://evident-carita-g23malhas-dd44508d.koyeb.app/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {

        if (user.getName() == null || user.getName().isEmpty() ||
            user.getEmail() == null || user.getEmail().isEmpty() ||
            user.getIdade() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos: nome, email e idade devem ser preenchidos corretamente.");
    }

    User newUser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

}

    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id)
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Usuario nao encontrado com id: " + id));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
