package com.ufg.inf.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.inf.cs.models.EnderecoModel;
import com.ufg.inf.cs.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

    @PostMapping  
	public ResponseEntity<EnderecoModel> salvarEndereco(@RequestBody EnderecoModel endereco) {
		EnderecoModel enderecoModel = enderecoRepository.save(endereco);	
	
		return new ResponseEntity<EnderecoModel>(enderecoModel, HttpStatus.OK);
	}

    @GetMapping(value = "/{id}")  
	public ResponseEntity<EnderecoModel> buscarEnderecoPorId(@PathVariable Long id) {
		EnderecoModel enderecos = enderecoRepository.findById(id).get();
	
		return new ResponseEntity<EnderecoModel>(enderecos, HttpStatus.OK);
	}

	@GetMapping(value = "/buscarPorLogradouro/{logradouro}")  
	public ResponseEntity<List<EnderecoModel>> buscarEnderecoPorLogradouro(@PathVariable String logradouro) {
		List<EnderecoModel> enderecos = enderecoRepository.buscarPeloLogradouro(logradouro.toUpperCase());
	
		return new ResponseEntity<List<EnderecoModel>>(enderecos, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		enderecoRepository.deleteById(id);
		
		return new ResponseEntity<String>("Endereço removido com sucesso.", HttpStatus.OK);
	}

	@PutMapping  
	public ResponseEntity<EnderecoModel> atualizarEndereco(@RequestBody EnderecoModel endereco) {
		EnderecoModel enderecoModel = enderecoRepository.save(endereco);	
	
		return new ResponseEntity<EnderecoModel>(enderecoModel, HttpStatus.OK);
	}
}
