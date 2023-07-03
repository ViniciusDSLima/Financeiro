package com.example.Challenge01.controller;

import com.example.Challenge01.domain.requisicao.Requisicao;
import com.example.Challenge01.service.RequisicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("requisicoes")
public class RequisicaoController {

    @Autowired
    RequisicaoService requisicaoService;

    @PostMapping
    public ResponseEntity<String> adicionarRequisicao(@RequestBody Requisicao requisicao){
        try{
            requisicaoService.adicionarRequisicao(requisicao);
            return ResponseEntity.ok("Requisicao criada com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
