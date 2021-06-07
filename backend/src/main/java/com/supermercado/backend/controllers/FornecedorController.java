package com.supermercado.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.backend.dto.FornecedorDto;
import com.supermercado.backend.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping
	public ResponseEntity<List<FornecedorDto>> findAll() {
		List <FornecedorDto> listaFinal = service.findAll();
		return ResponseEntity.ok().body(listaFinal);
	}

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDto> buscar(@PathVariable Integer id) {
        FornecedorDto fornecedorDto = service.findId(id);
        return ResponseEntity.ok().body(fornecedorDto);

    }
	
}
