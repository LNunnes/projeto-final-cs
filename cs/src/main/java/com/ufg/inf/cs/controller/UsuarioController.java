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

import com.ufg.inf.cs.models.UsuarioModel;
import com.ufg.inf.cs.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping  
	public ResponseEntity<UsuarioModel> criarUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel usuarioModel = usuarioRepository.save(usuario);
	
		return new ResponseEntity<UsuarioModel>(usuarioModel, HttpStatus.OK);
	}

    @PutMapping  
	public ResponseEntity<UsuarioModel> atualizarUsuario(@RequestBody UsuarioModel usuario) {
		UsuarioModel usuarioModel = usuarioRepository.save(usuario);
	
		return new ResponseEntity<UsuarioModel>(usuarioModel, HttpStatus.OK);
	}

  	@GetMapping(value = "/{id}")  
	public ResponseEntity<UsuarioModel> buscarUsuarioPorId(@PathVariable Long id) {
		UsuarioModel usuario = usuarioRepository.findById(id).get();
	
		return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
	}

	@GetMapping("/residentes/{republicaId}")
    public ResponseEntity<List<UsuarioModel>> listarResidentesPorRepublicaId(@PathVariable Long republicaId) {
        List<UsuarioModel> residentes = usuarioRepository.listarResidentes(republicaId);
        return new ResponseEntity<List<UsuarioModel>>(residentes, HttpStatus.OK);
    }

	@GetMapping("/gerentes/{republicaId}")
    public ResponseEntity<List<UsuarioModel>> listarGerentesPorRepublicaId(@PathVariable Long republicaId) {
        List<UsuarioModel> gerentes = usuarioRepository.listarGerentes(republicaId);

		return new ResponseEntity<List<UsuarioModel>>(gerentes, HttpStatus.OK);

    }

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		
		return new ResponseEntity<String>("Usuario deletado com sucesso.", HttpStatus.OK);
	}

}