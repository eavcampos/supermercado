package com.supermercado.backend.dto;

import java.io.Serializable;

import com.supermercado.backend.entities.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String endereco;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Integer id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public ClienteDTO(Cliente entity) {
		super();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.endereco = entity.getEndereco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
