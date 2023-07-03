package com.example.Challenge01.domain.despesas;

import com.example.Challenge01.DTO.depesas.DadosAtualizarDespesa;
import com.example.Challenge01.DTO.depesas.DadosCadastroDespesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "despesas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;
    private String descricao;
    private LocalDate data;

    public Despesa(DadosCadastroDespesa dadosCadastroDespesa) {
        this.data = dadosCadastroDespesa.date();
        this.descricao = dadosCadastroDespesa.descricao();
        this.valor = dadosCadastroDespesa.valor();
    }

    public void atualizarInformacoes(DadosAtualizarDespesa dadosAtualizarDespesa) {
        if(dadosAtualizarDespesa.data() != null){
            this.data = dadosAtualizarDespesa.data();
        }
        if(dadosAtualizarDespesa.descricao() != null){
            this.descricao = dadosAtualizarDespesa.descricao();
        }
        if(dadosAtualizarDespesa.valor() != null){
            this.valor = dadosAtualizarDespesa.valor();
        }
    }
}
