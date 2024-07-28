package com.ufg.inf.cs.controller;

import com.ufg.inf.cs.models.AcomodacaoModel;
import com.ufg.inf.cs.service.AcomodacaoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcomodacaoController {

    @Autowired
    private AcomodacaoService acomodacaoService;

    @PostMapping("/acomodacao")
    public ResponseEntity<AcomodacaoModel> criarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
            AcomodacaoModel acomodacaoModel = acomodacaoService.save(acomodacao);

            return ResponseEntity.ok(acomodacaoModel);
    }

    @DeleteMapping("/acomodacao/{id}")
    public ResponseEntity<String> deleteAcomodacao(@PathVariable Long id) {
        acomodacaoService.delete(id);

        return ResponseEntity.ok("Acomodação deletada com sucesso!");
    }

    @GetMapping("/acomodacao/{id}")
    public ResponseEntity<AcomodacaoModel> getAcomodacao(@PathVariable Long id) {
        AcomodacaoModel acomodacao = acomodacaoService.getAcomodacaoById(id);

        return ResponseEntity.ok(acomodacao);
    }

    @GetMapping("/acomodacao")
    public ResponseEntity<List<AcomodacaoModel>> getAcomodacoes(){
        List<AcomodacaoModel> acomodacoes = acomodacaoService.getListAcomodacoes();

        return ResponseEntity.ok(acomodacoes);
    }


}
