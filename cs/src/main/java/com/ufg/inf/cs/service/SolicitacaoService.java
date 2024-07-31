package com.ufg.inf.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufg.inf.cs.models.SolicitacaoModel;
import com.ufg.inf.cs.repository.SolicitacaoRepository;
import java.util.List;

@Service
public class SolicitacaoService {
    
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoModel salvarSolicitacao(SolicitacaoModel solicitacao) {
        return solicitacaoRepository.save(solicitacao);
    }

    public SolicitacaoModel buscarSolicitacaoPorId(Long id) {
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public void deletarSolicitacaoPorId(Long id) {
        solicitacaoRepository.deleteById(id);
    }

    public List<SolicitacaoModel> listaSolicitacoes() {
        return solicitacaoRepository.findAll();
    }

    public List<SolicitacaoModel> buscarPorRepublicaId(Long republicaId) {
        return solicitacaoRepository.findByRepublicaId(republicaId);
    }
}