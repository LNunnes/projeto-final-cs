package com.ufg.inf.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufg.inf.cs.models.FotoModel;
import com.ufg.inf.cs.service.FotoService;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping
    public ResponseEntity<FotoModel> criarFoto(@RequestBody FotoModel foto) {
        FotoModel novaFoto = fotoService.salvarFoto(foto);
        return new ResponseEntity<>(novaFoto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoModel> buscarFotoPorId(@PathVariable Long id) {
        FotoModel foto = fotoService.buscarFotoPorId(id);
        return ResponseEntity.ok(foto);
    }

    @GetMapping("/republica/{republicaId}")
    public ResponseEntity<List<FotoModel>> listarFotosPorRepublicaId(@PathVariable Long republicaId) {
        List<FotoModel> fotos = fotoService.listarFotosPorRepublicaId(republicaId);
        return ResponseEntity.ok(fotos);
    }

    @PutMapping
    public ResponseEntity<FotoModel> atualizarFoto(@RequestBody FotoModel foto) {
        FotoModel fotoAtualizada = fotoService.salvarFoto(foto);
        return new ResponseEntity<>(fotoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFotoPorId(@PathVariable Long id) {
        fotoService.deletarFotoPorId(id);
        return ResponseEntity.ok("Foto deletada.");
    }
}