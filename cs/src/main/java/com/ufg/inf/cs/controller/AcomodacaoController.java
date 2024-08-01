package com.ufg.inf.cs.controller;

import com.ufg.inf.cs.models.AcomodacaoModel;
import com.ufg.inf.cs.service.AcomodacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acomodacoes")
public class AcomodacaoController {

    @Autowired
    private AcomodacaoService acomodacaoService;

    @PostMapping
    public ResponseEntity<AcomodacaoModel> criarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
            AcomodacaoModel acomodacaoModel = acomodacaoService.salvarAcomodacao(acomodacao);

            return ResponseEntity.ok(acomodacaoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAcomodacao(@PathVariable Long id) {
        acomodacaoService.deletarAcomodacao(id);

        return ResponseEntity.ok("Acomodação deletada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcomodacaoModel> getAcomodacao(@PathVariable Long id) {
        AcomodacaoModel acomodacao = acomodacaoService.buscarAcomodacaoPorId(id);

        return ResponseEntity.ok(acomodacao);
    }

    @PutMapping
    public ResponseEntity<AcomodacaoModel> atualizarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
        AcomodacaoModel acomodacaoModel = acomodacaoService.salvarAcomodacao(acomodacao);

        return ResponseEntity.ok(acomodacaoModel);
    }

    @GetMapping
    public ResponseEntity<List<AcomodacaoModel>> getTodasAcomodacoes(){
        List<AcomodacaoModel> acomodacoes = acomodacaoService.buscarListaAcomodacoes();

        return ResponseEntity.ok(acomodacoes);
    }

}
