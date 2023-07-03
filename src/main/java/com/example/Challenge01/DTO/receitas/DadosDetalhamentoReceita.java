package com.example.Challenge01.DTO.receitas;

import com.example.Challenge01.domain.receita.Receita;

import java.time.LocalDate;

public record DadosDetalhamentoReceita(String descricao, String valor, LocalDate data) {

    public DadosDetalhamentoReceita(Receita receita){
        this(receita.getDescricao(), receita.getValor(), receita.getData());
    }
}
