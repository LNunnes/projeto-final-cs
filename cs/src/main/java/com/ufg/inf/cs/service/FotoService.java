package com.ufg.inf.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufg.inf.cs.models.FotoModel;
import com.ufg.inf.cs.repository.FotoRepository;

import java.util.List;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    public FotoModel salvarFoto(FotoModel foto) {
        return fotoRepository.save(foto);
    }

    public FotoModel buscarFotoPorId(Long id) {
        return fotoRepository.findById(id).orElse(null);
    }

    public void deletarFotoPorId(Long id) {
        fotoRepository.deleteById(id);
    }

    public List<FotoModel> listarFotos() {
        return fotoRepository.findAll();
    }

    public List<FotoModel> listarFotosPorRepublicaId(Long republicaId) {
        return fotoRepository.findAll();
    }
}