package com.example.Challenge01.DTO.receitas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroReceita(@NotBlank String descricao, @NotBlank String valor, @NotNull @JsonFormat(pattern = "dd/MM/yyyy") LocalDate data) {
}
