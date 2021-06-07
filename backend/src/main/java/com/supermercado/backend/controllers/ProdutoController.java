package com.supermercado.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.supermercado.backend.dto.ProdutoDto;
import com.supermercado.backend.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> findAll() {
		List <ProdutoDto> listaFinal = service.findAll();
		return ResponseEntity.ok().body(listaFinal);
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDto> buscar(@PathVariable Integer id) {
        ProdutoDto produtoDto = service.findId(id);
        return ResponseEntity.ok().body(produtoDto);

    }
	
	
/*	Esta versão do insert foi construida quando o cadastro ainda não tinha a imagem
 * 
 *
    @PostMapping
	public ResponseEntity<ProdutoDto> insert(@RequestBody ProdutoDto produtoDto) {
		produtoDto = service.insert(produtoDto);
		return ResponseEntity.ok().body(produtoDto);
	}
*/
    
	
	@PostMapping("/insert")
    public ResponseEntity<ProdutoDto> insert(ProdutoDto produtoDto, MultipartFile imagem) {
        produtoDto = service.insert(produtoDto, imagem); //cadastra os dados na tabela
        return ResponseEntity.ok(produtoDto);
    }
	
	/*	Esta versão do update construida quando o cadastro ainda não tinha a imagem
	 * 
	@PostMapping("/update")
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDto) {
        produtoDto = service.alterar(produtoDto);
        return ResponseEntity.ok(produtoDto);
    }
	*/
	
	@PutMapping("/update")
    public ResponseEntity<ProdutoDto> update(ProdutoDto produtoDto, MultipartFile imagem) {

		produtoDto = service.alterar(produtoDto, imagem);    
        return ResponseEntity.ok(produtoDto);
    }
	
	@GetMapping("/orderByDescricaoAsc")
	public ResponseEntity<List<ProdutoDto>> findAllByOrderByDescricaoAsc() {
		List <ProdutoDto> listaFinal = service.findAllByOrderByDescricaoAsc();
		return ResponseEntity.ok().body(listaFinal);
	}

	@GetMapping("/orderByPrecoVendaDesc")
	public ResponseEntity<List<ProdutoDto>> findAllByOrderByPrecoVendaDesc() {
		List <ProdutoDto> listaFinal = service.findAllByOrderByPrecoVendaDesc();
		return ResponseEntity.ok().body(listaFinal);
	}
	
	@GetMapping("/buscaPorDescricao")
	public ResponseEntity<List<ProdutoDto>> findByDescricao(@RequestParam("descricao") String param) {
		System.out.println("PARAMETRO = "+ param);
		List <ProdutoDto> listaFinal = service.findByDescricao(param);
		return ResponseEntity.ok().body(listaFinal);
	}	

	
}
