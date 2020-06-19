package com.br.tempotelecomteste.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.repositorios.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	@Transactional
	public ArrayList<Produto> findAllProdutos() {
		return (ArrayList<Produto>) repository.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return repository.findById(id);
		
	}
}
