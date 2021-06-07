package com.supermercado.backend.dto;

import java.io.Serializable;

import com.supermercado.backend.entities.Fornecedor;
import com.supermercado.backend.entities.Produto;

public class ProdutoDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private Double precoVenda;
	private Integer qtdEstoque;
	private String linkImagem;
	private Fornecedor fornecedor;

	
	public ProdutoDto() {
		super();
	}

	public ProdutoDto(Integer id, String descricao, Double precoVenda, Integer qtdEstoque, String linkImagem,
			Fornecedor fornecedor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
		this.linkImagem = linkImagem;
		this.fornecedor = fornecedor;
	}


	public ProdutoDto(Produto entity) {
		super();
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.precoVenda = entity.getPrecoVenda();
		this.qtdEstoque = entity.getQtdEstoque();
		this.linkImagem = entity.getLinkImagem();
		this.fornecedor = entity.getFornecedor();
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

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}	
	
	
}
