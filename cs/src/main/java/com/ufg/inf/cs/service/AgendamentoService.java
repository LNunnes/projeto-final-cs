package com.ufg.inf.cs.service;

import com.ufg.inf.cs.models.AgendamentoModel;
import com.ufg.inf.cs.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public AgendamentoModel buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id).orElse(null);
    }

    public List<AgendamentoModel> buscarAgendamentosPorEspaco(Long espacoComunitarioId) {
        return agendamentoRepository.findByEspacoComunitarioId(espacoComunitarioId);
    }
}
