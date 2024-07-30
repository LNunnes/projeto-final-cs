package com.ufg.inf.cs.service;

import com.ufg.inf.cs.models.DespesaModel;
import com.ufg.inf.cs.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository despesaRepository;

    public DespesaModel salvarDespesa(DespesaModel despesa) {
        return despesaRepository.save(despesa);
    }

    public void deletarDespesa(Long idDespesa) {
        despesaRepository.deleteById(idDespesa);
    }

    public DespesaModel buscarDespesaPorId(Long idDespesa) {
        return despesaRepository.findById(idDespesa).orElse(null);
    }

    public List<DespesaModel> buscarDespesasPorRepublica(Long republicaId) {
        return despesaRepository.findDespesasByRepublicaId(republicaId);
    }

}
