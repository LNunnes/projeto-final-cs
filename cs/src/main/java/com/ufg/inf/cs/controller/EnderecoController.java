package com.ufg.inf.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.inf.cs.models.EnderecoModel;
import com.ufg.inf.cs.repository.EnderecoRepository;
import com.ufg.inf.cs.service.EnderecoService;

@Controller
@RestController
public class EnderecoController {

    @Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

    @PostMapping(value = "**/endereco")  
	public ResponseEntity<EnderecoModel> salvarEndereco(@RequestBody EnderecoModel endereco) {
		EnderecoModel enderecoModel = enderecoService.save(endereco);	
	
		return new ResponseEntity<EnderecoModel>(enderecoModel, HttpStatus.OK);
	}

    @GetMapping(value = "**/endereco/{id}")  
	public ResponseEntity<EnderecoModel> buscarEnderecoPorId(@PathVariable Long id) {
		EnderecoModel enderecos = enderecoRepository.findById(id).get();
	
		return new ResponseEntity<EnderecoModel>(enderecos, HttpStatus.OK);
	}
}
