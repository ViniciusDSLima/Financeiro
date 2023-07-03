package com.example.Challenge01.service;

import com.example.Challenge01.domain.requisicao.Requisicao;
import com.example.Challenge01.repository.RequisicaoRepository;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisTypeAnnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicaoService {

    @Autowired
    RequisicaoRepository requisicaoRepository;

    public void adicionarRequisicao(Requisicao requisicao){
        List<Requisicao> requisicoesExistentes = requisicaoRepository.findByMesAndDescricao(requisicao.getMes(), requisicao.getDescricao());

        if(!requisicoesExistentes.isEmpty()){
            throw new RuntimeException("Nao foi possivel adicionar a requisicao pois a descricao e identica a outra ja existente no banco de dados");
        }

        requisicaoRepository.save(requisicao);

    }

}
