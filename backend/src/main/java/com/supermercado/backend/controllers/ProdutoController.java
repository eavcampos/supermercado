package com.supermercado.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.backend.dto.ProdutoDTO;
import com.supermercado.backend.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List <ProdutoDTO> listaFinal = service.findAll();
		return ResponseEntity.ok().body(listaFinal);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO produtoDTO) {
		produtoDTO = service.insert(produtoDTO);
		return ResponseEntity.ok().body(produtoDTO);
	}
	
	
	
	
	
	
	
	
	
	
	

}
