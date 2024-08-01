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

import com.ufg.inf.cs.models.TarefaModel;
import com.ufg.inf.cs.repository.TarefaRepository;

@Controller
@RestController
@RequestMapping("/tarefa")
public class TarefaController {

  @Autowired
  private TarefaRepository tarefaRepository;

  @PostMapping  
	  public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefa) {
		  TarefaModel tarefaModel = tarefaRepository.save(tarefa);
	
		  return new ResponseEntity<TarefaModel>(tarefaModel, HttpStatus.OK);
	}

    @PutMapping  
	public ResponseEntity<TarefaModel> atualizarTarefa(@RequestBody TarefaModel tarefa) {
		TarefaModel tarefaModel = tarefaRepository.save(tarefa);	
	
		return new ResponseEntity<TarefaModel>(tarefaModel, HttpStatus.OK);
	}

  @GetMapping(value = "/{id}")  
	  public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable Long id) {
		  TarefaModel tarefa = tarefaRepository.findById(id).get();
	
		  return new ResponseEntity<TarefaModel>(tarefa, HttpStatus.OK);
	}

    @GetMapping(value = "s")
	  public ResponseEntity<TarefaModel> buscarTodasTarefas() {
		  TarefaModel tarefa = tarefaRepository.findAll().get();
	
		  return new ResponseEntity<TarefaModel>(tarefa, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	  public ResponseEntity<String> delete(@PathVariable Long id) {
		tarefaRepository.deleteById(id);
		
		return new ResponseEntity<String>("Tarefa deletada com sucesso.", HttpStatus.OK);
	}

}