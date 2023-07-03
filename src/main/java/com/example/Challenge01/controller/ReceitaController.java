package com.example.Challenge01.controller;

import com.example.Challenge01.DTO.receitas.DadosAtualizarReceita;
import com.example.Challenge01.DTO.receitas.DadosCadastroReceita;
import com.example.Challenge01.DTO.receitas.DadosDetalhamentoReceita;
import com.example.Challenge01.domain.receita.Receita;
import com.example.Challenge01.repository.ReceitaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("receitas")
public class ReceitaController {

    @Autowired
    ReceitaRepository receitaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarReceita(@RequestBody @Valid DadosCadastroReceita dadosCadastroReceita, UriComponentsBuilder uriComponentsBuilder){
        var receitaCadastrada = receitaRepository.save(new Receita(dadosCadastroReceita));

        var uri = uriComponentsBuilder.path("receitas/{id}").buildAndExpand(receitaCadastrada).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoReceita>> buscarReceitas(@PageableDefault(size = 10, sort = {"data"})Pageable pageable){
        var listaReceitas = receitaRepository.findAll(pageable).map(DadosDetalhamentoReceita::new);

        return ResponseEntity.ok(listaReceitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarReceitaById(@PathVariable Long id){
        var receita = receitaRepository.findById(id);

        return ResponseEntity.ok(receita);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarReceita(@RequestBody @Valid DadosAtualizarReceita dadosAtualizarReceita){
        var receita = receitaRepository.getReferenceById(dadosAtualizarReceita.id());
        receita.atualizarInformacoes(dadosAtualizarReceita);

        return ResponseEntity.ok(new DadosDetalhamentoReceita(receita));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarReceitaById(@PathVariable Long id){
        receitaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
