package com.br.tempotelecomteste.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.services.ClienteService;
import com.br.tempotelecomteste.services.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@RequestMapping(value="/produtos/all" ,method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Produto> findAllClientes() {
		return service.findAllProdutos();
	}
}