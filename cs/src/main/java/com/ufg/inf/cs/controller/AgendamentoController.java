package com.ufg.inf.cs.controller;

import com.ufg.inf.cs.models.AgendamentoModel;
import com.ufg.inf.cs.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/agendamento")
    public ResponseEntity<AgendamentoModel> criarAgendamento(@RequestBody AgendamentoModel agendamento) {
        AgendamentoModel agendamentoModel = agendamentoService.salvarAgendamento(agendamento);

        return ResponseEntity.ok(agendamentoModel);
    }

    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<String> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);

        return ResponseEntity.ok("Agendamento deletado com sucesso!");
    }

    @PutMapping("/agendamento")
    public ResponseEntity<AgendamentoModel> atualizarAgendamento(@RequestBody AgendamentoModel agendamento) {
        AgendamentoModel agendamentoModel = agendamentoService.salvarAgendamento(agendamento);

        return ResponseEntity.ok(agendamentoModel);
    }

    @GetMapping("/agendamento/{id}")
    public ResponseEntity<AgendamentoModel> getAgendamento(@PathVariable Long id) {
        AgendamentoModel agendamento = agendamentoService.buscarAgendamentoPorId(id);

        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/agendamentos/espaco-comunitario/{id}")
    public ResponseEntity<List<AgendamentoModel>> getAgendamentosPorEspacoComunitario(@PathVariable Long id) {
        List<AgendamentoModel> agendamentos = agendamentoService.buscarAgendamentosPorEspaco(id);
        return ResponseEntity.ok(agendamentos);
    }
}
