package com.example.Challenge01.controller;

import com.example.Challenge01.DTO.security.AuthenticationDTO;
import com.example.Challenge01.DTO.security.CadastroDTO;
import com.example.Challenge01.domain.ussuarios.Usuarios;
import com.example.Challenge01.repository.UsuarioRepository;
import com.example.Challenge01.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());

        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((Usuarios) auth.getPrincipal());


        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroDTO cadastroDTO){
        if(this.usuarioRepository.findByEmail(cadastroDTO.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassowrd = new BCryptPasswordEncoder().encode(cadastroDTO.password());
        Usuarios newUser = new Usuarios(cadastroDTO.email(), encryptedPassowrd, cadastroDTO.role());

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
