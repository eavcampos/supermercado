package com.supermercado.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.supermercado.backend.dto.ProdutoDto;
import com.supermercado.backend.entities.Produto;
import com.supermercado.backend.repositories.ProdutoRepository;
import com.supermercado.backend.utilities.AcessaDisco;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private AcessaDisco acesso; 
		
	@Transactional(readOnly = true)
	public List<ProdutoDto> findAll() {
		List<Produto> lista = repository.findAll();
		List<ProdutoDto> listaDTO = new ArrayList<ProdutoDto>();
		for(int i=0; i<lista.size(); i++) {
			ProdutoDto temp = new ProdutoDto();
			temp.setId(lista.get(i).getId());
			temp.setDescricao(lista.get(i).getDescricao());
			temp.setPrecoVenda(lista.get(i).getPrecoVenda());
			temp.setQtdEstoque(lista.get(i).getQtdEstoque());
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
	
    public ProdutoDto findId(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        ProdutoDto produtoDto = new ProdutoDto(produto.get());
        return produtoDto; //.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! ID: " + id + ", Tipo"+ ProdutoService.class.getName()));

    }
	
	public ProdutoDto insert(ProdutoDto prodDto, MultipartFile imagem) {
    //public ProdutoDto insert(ProdutoDto prodDto) {
		Produto produto = new Produto(prodDto.getId(), prodDto.getDescricao(), prodDto.getPrecoVenda(), 
				prodDto.getQtdEstoque(), prodDto.getLinkImagem(), prodDto.getFornecedor());

		produto = repository.save(produto);
		acesso.salvar("imagem-produtos", imagem); //grava a imagem do produto em algum sistema de arquivos
		return new ProdutoDto(produto);
		
	}
	
	@Transactional(readOnly = false)
	public ProdutoDto alterar(ProdutoDto prodDto,  MultipartFile imagem) {
		Produto produto = new Produto(prodDto.getId(), prodDto.getDescricao(), prodDto.getPrecoVenda(), 
				prodDto.getQtdEstoque(), prodDto.getLinkImagem(), prodDto.getFornecedor());
		
		Optional<Produto> prodASerAlterado = repository.findById (produto.getId());
		acesso.excluir("imagem-produtos", prodASerAlterado.get().getLinkImagem()); //apaga imagem antiga
		produto = repository.save(produto);
	    acesso.salvar("imagem-produtos", imagem); //grava imagem nova
		return new ProdutoDto(produto);
		
	}
	
	//------------------------
	
	@Transactional(readOnly = true)
	public List<ProdutoDto> findAllByOrderByDescricaoAsc() {
		List<Produto> lista = repository.findAllByOrderByDescricaoAsc();
		List<ProdutoDto> listaDTO = new ArrayList<ProdutoDto>();
		for(int i=0; i<lista.size(); i++) {
			ProdutoDto temp = new ProdutoDto(lista.get(i));
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
	@Transactional(readOnly = true)
	public List<ProdutoDto> findAllByOrderByPrecoVendaDesc() {
		List<Produto> lista = repository.findAllByOrderByPrecoVendaDesc();
		List<ProdutoDto> listaDTO = new ArrayList<ProdutoDto>();
		for(int i=0; i<lista.size(); i++) {
			ProdutoDto temp = new ProdutoDto(lista.get(i));
			listaDTO.add(temp);
		}
		return listaDTO;
	}


	@Transactional(readOnly = true)
	public List<ProdutoDto> findByDescricao(String param) {
		List<Produto> lista = repository.findByDescricao(param);
		List<ProdutoDto> listaDTO = new ArrayList<ProdutoDto>();
		for(int i=0; i<lista.size(); i++) {
			ProdutoDto temp = new ProdutoDto(lista.get(i));
			
			listaDTO.add(temp);
		}
		return listaDTO;
	}
	
	
	
}
