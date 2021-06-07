package com.supermercado.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supermercado.backend.dto.FornecedorDto;
import com.supermercado.backend.entities.Fornecedor;
import com.supermercado.backend.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
		
	@Transactional(readOnly = true)
	
	public List<FornecedorDto> findAll() {
		List<Fornecedor> lista = repository.findAll();
		List<FornecedorDto> listaDTO = new ArrayList<FornecedorDto>();
		
		for(int i=0; i<lista.size(); i++) {
			FornecedorDto temp = new FornecedorDto(lista.get(i));
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
    public FornecedorDto findId(Integer id) {
        Optional<Fornecedor> fornecedor = repository.findById(id);
        FornecedorDto fornecedorDto = new FornecedorDto(fornecedor.get());
        return fornecedorDto; //.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! ID: " + id + ", Tipo"+ ProdutoService.class.getName()));

    }
}
