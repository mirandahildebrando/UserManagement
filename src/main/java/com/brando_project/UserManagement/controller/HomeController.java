package com.brando_project.UserManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Endpoint raiz
    @GetMapping("/")
    public String home() {
        return "API de Usuários rodando com sucesso! 🚀 Use /api/users para acessar os endpoints.";
    }
}

