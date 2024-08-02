package com.ufg.inf.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufg.inf.cs.models.SolicitacaoModel;
import com.ufg.inf.cs.service.SolicitacaoService;

import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @PostMapping
    public ResponseEntity<SolicitacaoModel> criarSolicitacao(@RequestBody SolicitacaoModel solicitacao) {
        if (solicitacao.getDespesa() != null) {
            solicitacao.getDespesa().setSolicitacao(solicitacao);
        }

        SolicitacaoModel solicitacaoModel = solicitacaoService.salvarSolicitacao(solicitacao);
        return new ResponseEntity<>(solicitacaoModel, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SolicitacaoModel> atualizarSolicitacao(@RequestBody SolicitacaoModel solicitacao) {
        if (solicitacao.getDespesa() != null) {
            solicitacao.getDespesa().setSolicitacao(solicitacao);
        }
        
        SolicitacaoModel solicitacaoModel = solicitacaoService.salvarSolicitacao(solicitacao);
        return new ResponseEntity<>(solicitacaoModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSolicitacaoPorId(@PathVariable Long id) {
        solicitacaoService.deletarSolicitacaoPorId(id);
        return ResponseEntity.ok("Solicitação deletada.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoModel> buscarSolicitacaoPorId(@PathVariable Long id) {
        SolicitacaoModel solicitacao = solicitacaoService.buscarSolicitacaoPorId(id);
        return ResponseEntity.ok(solicitacao);
    }

    @GetMapping("/republica/{republicaId}")
    public ResponseEntity<List<SolicitacaoModel>> buscarSolicitacoesPorRepublicaId(@PathVariable Long republicaId) {
        List<SolicitacaoModel> solicitacoes = solicitacaoService.buscarPorRepublicaId(republicaId);
        return ResponseEntity.ok(solicitacoes);
    }
}