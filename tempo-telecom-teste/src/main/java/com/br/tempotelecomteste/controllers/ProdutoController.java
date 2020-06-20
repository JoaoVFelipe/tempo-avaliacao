package com.br.tempotelecomteste.controllers;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@CrossOrigin 
	@GetMapping(value="/produtos/all")
	public ArrayList<Produto> findAllClientes() {
		return service.findAllProdutos();
	}
	
	@CrossOrigin 
	@PostMapping(value="/produtos/salvar")
	public Produto saveProduto(@RequestBody JSONObject jsonPedido) {
		return service.saveProduto(jsonPedido);
	}
}