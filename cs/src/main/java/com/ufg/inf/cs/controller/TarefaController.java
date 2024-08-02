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

import com.ufg.inf.cs.models.TarefaModel;
import com.ufg.inf.cs.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
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
	public ResponseEntity<TarefaModel> buscarTarefaPorId(@PathVariable Long id) throws Exception {
		TarefaModel tarefa = tarefaRepository.findById(id).get();
	
		if (tarefa == null) {
			throw new Exception("Não existe tarefa cadastrada com esse código. Código: " + id);
		}

		return new ResponseEntity<TarefaModel>(tarefa, HttpStatus.OK);
	}

    @GetMapping
	public ResponseEntity<List<TarefaModel>> buscarTodasTarefas() {
		List<TarefaModel> tarefas = tarefaRepository.findAll();
	
		return new ResponseEntity<List<TarefaModel>>(tarefas, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		tarefaRepository.deleteById(id);
		
		return new ResponseEntity<String>("Tarefa deletada com sucesso.", HttpStatus.OK);
	}

}