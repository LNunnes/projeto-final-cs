package com.ufg.inf.cs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufg.inf.cs.models.EnderecoModel;
import com.ufg.inf.cs.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
	private EnderecoRepository enderecoRepository;
	
	public EnderecoModel save(EnderecoModel endereco) {
		return enderecoRepository.save(endereco);
	}
}
