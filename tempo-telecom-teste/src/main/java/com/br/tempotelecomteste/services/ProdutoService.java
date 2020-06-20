package com.br.tempotelecomteste.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.repositorios.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	/**
	 * Busca todos os produtos para listagem
	 * 
	 * */
	@Transactional
	public ArrayList<Produto> findAllProdutos() {
		return (ArrayList<Produto>) repository.findAll();
	}

	/**
	 * Busca todos produto a partir do id
	 * 
	 * @param id
	 * 				ID do produto
	 * 
	 * @return Um Optional de produto
	 * 
	 * */
	public Optional<Produto> findById(Long id) {
		return repository.findById(id);
		
	}
	
	/**
	 * Salva produto
	 * 
	 * @param jsonProduto
	 * 				JSONObject com os dados do produto
	 * 
	 * @return produto salvo em caso de sucesso, ou null em caso de erro
	 * 
	 * */
	@Transactional
	public Produto saveProduto(JSONObject jsonProduto) {
		Produto produto = new Produto();
		
		produto.setNome((String) jsonProduto.get("nome"));
		produto.setValor(Double.valueOf((String) jsonProduto.get("valor")));

		return repository.save(produto);
	}
}
