package com.supermercado.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supermercado.backend.dto.ClienteDto;
import com.supermercado.backend.entities.Cliente;
import com.supermercado.backend.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
		
	@Transactional(readOnly = true)
	
	public List<ClienteDto> findAll() {
		List<Cliente> lista = repository.findAll();
		List<ClienteDto> listaDTO = new ArrayList<ClienteDto>();
		
		for(int i=0; i<lista.size(); i++) {
			ClienteDto temp = new ClienteDto(lista.get(i));
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
}
