package com.supermercado.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.backend.dto.ClienteDTO;
import com.supermercado.backend.dto.ProdutoDTO;
import com.supermercado.backend.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List <ClienteDTO> listaFinal = service.findAll();
		return ResponseEntity.ok().body(listaFinal);
	}

}
