package com.example.Challenge01.DTO.security;

import com.example.Challenge01.domain.UserRole;

public record CadastroDTO(String email, String password, UserRole role) {
}
