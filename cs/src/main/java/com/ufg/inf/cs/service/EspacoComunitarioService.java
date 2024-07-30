package com.ufg.inf.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufg.inf.cs.models.EspacoComunitarioModel;
import com.ufg.inf.cs.repository.EspacoComunitarioRepository;

import java.util.List;

@Service
public class EspacoComunitarioService {
    
    @Autowired
    private EspacoComunitarioRepository espacoComunitarioRepository;

    public EspacoComunitarioModel salvarEspacoComunitario(EspacoComunitarioModel espacoComunitario) {
        return espacoComunitarioRepository.save(espacoComunitario);
    }

    public EspacoComunitarioModel buscarEspacoComunitarioPorId(Long id) {
        return espacoComunitarioRepository.findById(id).orElse(null);
    }

    public void deletarEspacoComunitarioPorId(Long id) {
        espacoComunitarioRepository.deleteById(id);
    }

    public List<EspacoComunitarioModel> listaEspacosComunitarios() {
        return espacoComunitarioRepository.findAll();
    }

}