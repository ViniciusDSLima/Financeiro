package com.example.Challenge01.DTO.depesas;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroDespesa(@NotBlank String descricao,@NotBlank String valor,@NotBlank LocalDate date) {
}
