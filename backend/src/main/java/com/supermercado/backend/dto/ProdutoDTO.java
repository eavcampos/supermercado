package com.supermercado.backend.dto;

import java.io.Serializable;

import com.supermercado.backend.entities.Produto;

public class ProdutoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private Double precoVenda;
	private Integer qtdEstoque;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer id, String descricao, Double precoVenda, Integer qtdEstoque) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
	}
	
	public ProdutoDTO(Produto entity) {
		super();
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.precoVenda = entity.getPrecoVenda();
		this.qtdEstoque = entity.getQtdEstoque();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	
}
