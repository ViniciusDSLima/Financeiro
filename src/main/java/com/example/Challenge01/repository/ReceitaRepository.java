package com.example.Challenge01.repository;

import com.example.Challenge01.domain.receita.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    boolean findByData(LocalDate data);

    boolean existsByDescricaoAndData(String descricao, LocalDate data);
}
