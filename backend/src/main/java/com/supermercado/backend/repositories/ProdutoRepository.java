package com.supermercado.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.backend.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	
	

}
