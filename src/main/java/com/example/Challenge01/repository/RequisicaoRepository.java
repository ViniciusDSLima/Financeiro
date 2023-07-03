package com.example.Challenge01.repository;

import com.example.Challenge01.domain.requisicao.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {

    List<Requisicao> findByMesAndDescricao(int mes, String descricao);
}
