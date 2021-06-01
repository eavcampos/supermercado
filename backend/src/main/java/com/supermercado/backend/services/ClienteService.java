package com.supermercado.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supermercado.backend.dto.ClienteDTO;
import com.supermercado.backend.entities.Cliente;
import com.supermercado.backend.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
		
	@Transactional(readOnly = true)
	
	public List<ClienteDTO> findAll() {
		List<Cliente> lista = repository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
		
		for(int i=0; i<lista.size(); i++) {
			ClienteDTO temp = new ClienteDTO(lista.get(i));
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
}
