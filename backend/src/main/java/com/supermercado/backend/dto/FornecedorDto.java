package com.supermercado.backend.dto;

import java.io.Serializable;

import com.supermercado.backend.entities.Fornecedor;

public class FornecedorDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String razaoSocial;
	private String nomeFantasia;
	private String endereco;
	
	public FornecedorDto() {
		super();
	}

	
	
	public FornecedorDto(Integer id, String razaoSocial, String nomeFantasia, String endereco) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
	}
	
	public FornecedorDto(Fornecedor entity) {
		super();
		this.id = entity.getId();
		this.razaoSocial = entity.getRazaoSocial();
		this.nomeFantasia = entity.getNomeFantasia();
		this.endereco = entity.getEndereco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
