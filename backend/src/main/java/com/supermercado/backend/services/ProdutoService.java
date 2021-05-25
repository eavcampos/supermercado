package com.supermercado.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supermercado.backend.dto.ProdutoDTO;
import com.supermercado.backend.entities.Produto;
import com.supermercado.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
		
	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> lista = repository.findAll();
		List<ProdutoDTO> listaDTO = new ArrayList<ProdutoDTO>();
		for(int i=0; i<lista.size(); i++) {
			ProdutoDTO temp = new ProdutoDTO();
			temp.setId(lista.get(i).getId());
			temp.setDescricao(lista.get(i).getDescricao());
			temp.setPrecoVenda(lista.get(i).getPrecoVenda());
			temp.setQtdEstoque(lista.get(i).getQtdEstoque());
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
	
	public ProdutoDTO insert(ProdutoDTO prodDto) {
		Produto produto = new Produto(prodDto.getId(), prodDto.getDescricao(), prodDto.getPrecoVenda(), 
				prodDto.getQtdEstoque());
		
		/*OU
		
		Produto produto = new Produto();
		produto.setId(prodDto.getId());
		produto.setDescricao(prodDto.getDescricao());
		produto.setPrecoVenda(prodDto.getPrecoVenda());
		produto.setQtdEstoque(prodDto.getQtdEstoque());
		*/
		
		produto = repository.save(produto);
		return new ProdutoDTO(produto);
		
	}
	
}
