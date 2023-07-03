package com.example.Challenge01.repository;

import com.example.Challenge01.domain.despesas.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
