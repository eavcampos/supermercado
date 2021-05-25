package com.supermercado.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermercado.backend.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

	
}
