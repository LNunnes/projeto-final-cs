package com.ufg.inf.cs.controller;

import com.ufg.inf.cs.models.AcomodacaoModel;
import com.ufg.inf.cs.service.AcomodacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class AcomodacaoController {

    @Autowired
    private AcomodacaoService acomodacaoService;

    @PostMapping("/acomodacao")
    public ResponseEntity<AcomodacaoModel> criarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
            AcomodacaoModel acomodacaoModel = acomodacaoService.salvarAcomodacao(acomodacao);

            return ResponseEntity.ok(acomodacaoModel);
    }

    @DeleteMapping("/acomodacao/{id}")
    public ResponseEntity<String> deletarAcomodacao(@PathVariable Long id) {
        acomodacaoService.deletarAcomodacao(id);

        return ResponseEntity.ok("Acomodação deletada com sucesso!");
    }

    @GetMapping("/acomodacao/{id}")
    public ResponseEntity<AcomodacaoModel> getAcomodacao(@PathVariable Long id) {
        AcomodacaoModel acomodacao = acomodacaoService.buscarAcomodacaoPorId(id);

        return ResponseEntity.ok(acomodacao);
    }

    @PutMapping("/acomodacao")
    public ResponseEntity<AcomodacaoModel> atualizarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
        AcomodacaoModel acomodacaoModel = acomodacaoService.salvarAcomodacao(acomodacao);

        return ResponseEntity.ok(acomodacaoModel);
    }

    @GetMapping("/acomodacoes")
    public ResponseEntity<List<AcomodacaoModel>> getTodasAcomodacoes(){
        List<AcomodacaoModel> acomodacoes = acomodacaoService.buscarListaAcomodacoes();

        return ResponseEntity.ok(acomodacoes);
    }


}
