package com.ufg.inf.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufg.inf.cs.models.EspacoComunitarioModel;
import com.ufg.inf.cs.service.EspacoComunitarioService;

import java.util.List;

@RestController
@RequestMapping("/espacosComunitarios")

public class EspacoComunitarioController {
    @Autowired
    private EspacoComunitarioService espacoComunitarioService;

    @PostMapping
    public ResponseEntity<EspacoComunitarioModel> criarEspacoComunitario(@RequestBody EspacoComunitarioModel espacoComunitario) {
        EspacoComunitarioModel espacoComunitarioModel = espacoComunitarioService.salvarEspacoComunitario(espacoComunitario);
        
        return new ResponseEntity<>(espacoComunitarioModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
     public ResponseEntity<EspacoComunitarioModel> buscarEspacoComunitarioPorId(@PathVariable Long id) {
         EspacoComunitarioModel espacoComunitario = espacoComunitarioService.buscarEspacoComunitarioPorId(id);

         return ResponseEntity.ok(espacoComunitario);
     }

     @GetMapping
     public ResponseEntity<List<EspacoComunitarioModel>> listaEspacosComunitarios() {
         List<EspacoComunitarioModel> espacosComunitarios = espacoComunitarioService.listaEspacosComunitarios();

         return ResponseEntity.ok(espacosComunitarios);
     }

     @PutMapping
    public ResponseEntity<EspacoComunitarioModel> atualizarEspacoComunitario(@RequestBody EspacoComunitarioModel espacoComunitario) {
        EspacoComunitarioModel espacoComunitarioModel = espacoComunitarioService.salvarEspacoComunitario(espacoComunitario);
        
        return new ResponseEntity<>(espacoComunitarioModel, HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> deletarEspacoComunitarioPorId(@PathVariable Long id) {
         espacoComunitarioService.deletarEspacoComunitarioPorId(id);

         return ResponseEntity.ok("Espaço Comunitário deletado.");
     }
}
