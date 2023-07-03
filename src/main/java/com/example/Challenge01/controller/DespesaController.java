package com.example.Challenge01.controller;

import com.example.Challenge01.DTO.depesas.DadosCadastroDespesa;
import com.example.Challenge01.DTO.depesas.DadosAtualizarDespesa;
import com.example.Challenge01.DTO.depesas.DadosDetalhamentoDespesa;
import com.example.Challenge01.domain.despesas.Despesa;
import com.example.Challenge01.repository.DespesaRepository;
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
@RequestMapping("despesas")
public class DespesaController {

    @Autowired
    DespesaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarDespesas(@RequestBody @Valid DadosCadastroDespesa dadosCadastroDespesa, UriComponentsBuilder uriComponentsBuilder){
        var despesaCadastrada = repository.save(new Despesa(dadosCadastroDespesa));

        var uri = uriComponentsBuilder.path("despesas/{id}").buildAndExpand(despesaCadastrada).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarDespesas(@RequestBody @Valid DadosAtualizarDespesa dadosAtualizarDespesa){
        var despesa = repository.getReferenceById(dadosAtualizarDespesa.id());
        despesa.atualizarInformacoes(dadosAtualizarDespesa);

        return ResponseEntity.ok(new DadosDetalhamentoDespesa(despesa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoDespesa>> buscarDespesas(@PageableDefault(size = 10, sort = {"data"})Pageable pageable){
        var buscarDespesas = repository.findAll(pageable).map(DadosDetalhamentoDespesa::new);

        return ResponseEntity.ok(buscarDespesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarDespesasById(@PathVariable Long id){
        var despesa = repository.findById(id);

        return ResponseEntity.ok(despesa);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity apagarDespesasById(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
