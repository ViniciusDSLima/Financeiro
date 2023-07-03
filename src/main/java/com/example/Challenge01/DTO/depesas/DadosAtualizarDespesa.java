package com.example.Challenge01.DTO.depesas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarDespesa(@NotNull Long id, String descricao, String valor,@JsonFormat(pattern = "dd/MM/yyyy") LocalDate data) {
}
