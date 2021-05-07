package com.app.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JuegoDto;
import com.app.mapper.JuegoMapper;
import com.app.model.Juego;
import com.app.repositorio.JuegoRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class JuegoController {
	
	private final JuegoRepository repository;	
	
	private JuegoMapper mapper;	

	@GetMapping("/listar")
	public ResponseEntity<List<JuegoDto>> listar(){
		
		List<Juego> juegos = repository.findAll();
		List<JuegoDto> juegosDto = mapper.dtosToEntitys(juegos);
		if (juegos.isEmpty()) {
			throw new EntityNotFoundException("la lista de usuarios esta vacia");
		}
		return ResponseEntity.ok(juegosDto);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<JuegoDto> findById(@PathVariable Long id) {
		
		JuegoDto juegosDto =null;
		Juego juegos = null;
		if (repository.findById(id) == null) {
			new EntityNotFoundException("id no encontrado");
		}else {
			juegos = repository.findById(id).get();
			 juegosDto = mapper.entityToDto(juegos);
		}
		
		return ResponseEntity.ok(juegosDto);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Juego> create(@RequestBody JuegoDto juegosDto) {
		Juego juego = new Juego();
		juego = mapper.dtoToEntity(juegosDto);
		return ResponseEntity.ok(repository.save(juego));
	}
}
