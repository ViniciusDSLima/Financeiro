package com.example.Challenge01.repository;

import com.example.Challenge01.domain.ussuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByEmail(String email);
}
