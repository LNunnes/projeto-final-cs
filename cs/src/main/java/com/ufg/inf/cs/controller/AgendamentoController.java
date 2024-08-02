package com.ufg.inf.cs.controller;

import com.ufg.inf.cs.models.AgendamentoModel;
import com.ufg.inf.cs.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoModel> criarAgendamento(@RequestBody AgendamentoModel agendamento) {
        AgendamentoModel agendamentoModel = agendamentoService.salvarAgendamento(agendamento);

        return ResponseEntity.ok(agendamentoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);

        return ResponseEntity.ok("Agendamento deletado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<AgendamentoModel> atualizarAgendamento(@RequestBody AgendamentoModel agendamento) {
        AgendamentoModel agendamentoModel = agendamentoService.salvarAgendamento(agendamento);

        return ResponseEntity.ok(agendamentoModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoModel> getAgendamento(@PathVariable Long id) throws Exception {
        AgendamentoModel agendamento = agendamentoService.buscarAgendamentoPorId(id);

        if (agendamento == null) {
			throw new Exception("Não existe agendamento cadastrado com esse código. Código: " + id);
		}

        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/espacoComunitario/{id}")
    public ResponseEntity<List<AgendamentoModel>> getAgendamentosPorEspacoComunitario(@PathVariable Long id) {
        List<AgendamentoModel> agendamentos = agendamentoService.buscarAgendamentosPorEspaco(id);
        return ResponseEntity.ok(agendamentos);
    }
}
