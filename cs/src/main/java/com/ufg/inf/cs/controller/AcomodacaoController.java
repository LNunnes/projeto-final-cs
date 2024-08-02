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
    public ResponseEntity<AcomodacaoModel> getAcomodacao(@PathVariable Long id) throws Exception {
        AcomodacaoModel acomodacao = acomodacaoService.buscarAcomodacaoPorId(id);

        if (acomodacao == null) {
			throw new Exception("Não existe acomodação cadastrada com esse código. Código: " + id);
		}

        return ResponseEntity.ok(acomodacao);
    }

    @PutMapping
    public ResponseEntity<AcomodacaoModel> atualizarAcomodacao(@RequestBody AcomodacaoModel acomodacao) {
        AcomodacaoModel acomodacaoModel = acomodacaoService.salvarAcomodacao(acomodacao);

        return ResponseEntity.ok(acomodacaoModel);
    }

    @GetMapping
    public ResponseEntity<List<AcomodacaoModel>> getTodasAcomodacoes() throws Exception{
        List<AcomodacaoModel> acomodacoes = acomodacaoService.buscarListaAcomodacoes();

        if (acomodacoes.size() == 0) {
			throw new Exception("Não existe acomodações cadastradas.");
		}

        return ResponseEntity.ok(acomodacoes);
    }

}
