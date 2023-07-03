package com.example.Challenge01.domain.receita;

import com.example.Challenge01.DTO.receitas.DadosAtualizarReceita;
import com.example.Challenge01.DTO.receitas.DadosCadastroReceita;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "receitas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String valor;
    public String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate data;


    public Receita(DadosCadastroReceita dadosCadastroReceita) {
        this.valor = dadosCadastroReceita.valor();
        this.descricao = dadosCadastroReceita.descricao();
        this.data = dadosCadastroReceita.data();
    }

    public void atualizarInformacoes(DadosAtualizarReceita dadosAtualizarReceita) {
        if(dadosAtualizarReceita.valor()!= null){
            this.valor = dadosAtualizarReceita.valor();
        }
        if(dadosAtualizarReceita.descricao() != null){
            this.descricao = dadosAtualizarReceita.descricao();
        }
        if(dadosAtualizarReceita.date()  != null){
            this.data = dadosAtualizarReceita.date();
        }
    }
}
