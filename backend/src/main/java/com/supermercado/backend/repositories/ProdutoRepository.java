package com.supermercado.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.backend.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	public Optional<Produto> findById(Integer id);
	
	public List<Produto> findAllByOrderByDescricaoAsc();	
	
	public List<Produto> findAllByOrderByPrecoVendaDesc();
		
	public List<Produto> findByDescricao(String param);
	
	
}
