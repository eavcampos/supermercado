package com.supermercado.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.backend.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
	

	
}
