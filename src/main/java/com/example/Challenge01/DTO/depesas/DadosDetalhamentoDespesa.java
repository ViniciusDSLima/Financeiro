package com.example.Challenge01.DTO.depesas;

import com.example.Challenge01.domain.despesas.Despesa;

import java.time.LocalDate;

public record DadosDetalhamentoDespesa(String descricao, String valor, LocalDate date) {

    public DadosDetalhamentoDespesa(Despesa despesa){
        this(despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
