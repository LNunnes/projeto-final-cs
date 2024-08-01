package com.ufg.inf.cs.controller;

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

import com.ufg.inf.cs.models.RepublicaModel;
import com.ufg.inf.cs.repository.RepublicaRepository;

@RestController
@RequestMapping("/republicas")
public class RepublicaController {
    
    @Autowired
    private RepublicaRepository republicaRepository;

    @PostMapping  
	public ResponseEntity<RepublicaModel> salvarRepublica(@RequestBody RepublicaModel republica) {
		RepublicaModel republicaModel = republicaRepository.save(republica);	
	
		return new ResponseEntity<RepublicaModel>(republicaModel, HttpStatus.OK);
	}

	@PutMapping  
	public ResponseEntity<RepublicaModel> atualizarRepublica(@RequestBody RepublicaModel republica) {
		RepublicaModel republicaModel = republicaRepository.save(republica);	
	
		return new ResponseEntity<RepublicaModel>(republicaModel, HttpStatus.OK);
	}

    @GetMapping(value = "/{id}")  
	public ResponseEntity<RepublicaModel> buscarRepublicaPorId(@PathVariable Long id) {
		RepublicaModel republica = republicaRepository.findById(id).get();
	
		return new ResponseEntity<RepublicaModel>(republica, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		republicaRepository.deleteById(id);
		
		return new ResponseEntity<String>("República removida com sucesso.", HttpStatus.OK);
	}

}
