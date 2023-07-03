package com.example.Challenge01.domain.requisicao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requisicoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mes;
    private String descricao;
}
