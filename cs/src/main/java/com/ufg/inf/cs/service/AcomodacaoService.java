package com.ufg.inf.cs.service;

import com.ufg.inf.cs.models.AcomodacaoModel;
import com.ufg.inf.cs.repository.AcomodacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcomodacaoService {
    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public AcomodacaoModel salvarAcomodacao(AcomodacaoModel acomodacao){
       return acomodacaoRepository.save(acomodacao);
    }

    public void deletarAcomodacao(Long id){
        acomodacaoRepository.deleteById(id);
    }

    public AcomodacaoModel buscarAcomodacaoPorId(Long id){
        return acomodacaoRepository.findById(id).orElse(null);
    }

    public List<AcomodacaoModel> buscarListaAcomodacoes(){
        return acomodacaoRepository.findAll();
    }
}

