package com.ufg.inf.cs.controller;


import com.ufg.inf.cs.models.DespesaModel;
import com.ufg.inf.cs.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaModel> criarDespesa(@RequestBody DespesaModel despesa) {
        DespesaModel despesaModel = despesaService.salvarDespesa(despesa);

        return ResponseEntity.ok(despesaModel);
    }

    @PutMapping
    public ResponseEntity<DespesaModel> atualizarDespesa(@RequestBody DespesaModel despesa) {
        DespesaModel despesaModel = despesaService.salvarDespesa(despesa);

        return ResponseEntity.ok(despesaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDespesa(@PathVariable Long id) {
        despesaService.deletarDespesa(id);

        return ResponseEntity.ok("Despesa deletada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaModel> getDespesa(@PathVariable Long id) {
        DespesaModel despesa = despesaService.buscarDespesaPorId(id);

        return ResponseEntity.ok(despesa);
    }

    @GetMapping("/republica/{id}")
    public ResponseEntity<List<DespesaModel>> getDespesasPorRepublica(@PathVariable Long id) {
        List<DespesaModel> despesas = despesaService.buscarDespesasPorRepublica(id);

        return ResponseEntity.ok(despesas);
    }

}
