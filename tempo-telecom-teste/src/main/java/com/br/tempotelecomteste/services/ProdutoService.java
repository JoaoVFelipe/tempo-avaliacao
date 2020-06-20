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
	
	@Transactional
	public ArrayList<Produto> findAllProdutos() {
		return (ArrayList<Produto>) repository.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return repository.findById(id);
		
	}

	public void saveProduto(JSONObject jsonPedido) throws ParseException {
		Produto produto = new Produto();
		
		produto.setNome((String) jsonPedido.get("nome"));
		produto.setValor((Double) jsonPedido.get("valor"));

		repository.save(produto);
	}
}
