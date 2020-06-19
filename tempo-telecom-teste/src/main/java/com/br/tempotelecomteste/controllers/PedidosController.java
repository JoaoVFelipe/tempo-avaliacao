package com.br.tempotelecomteste.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.pedido.Pedido;
import com.br.tempotelecomteste.entidades.pedido.PedidoProdutos;
import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.services.PedidosService;
import com.br.tempotelecomteste.services.ProdutoService;



@RestController
public class PedidosController {
	
	@Autowired
	PedidosService service;
	
	@Autowired
	ProdutoService produtoService;
	
	@CrossOrigin 
	@GetMapping(value="/pedidos/all")
	public ArrayList<Pedido> findAllPedidos() {
		ArrayList<Pedido> listaPedidos = service.findAllPedidos();
		ArrayList<PedidoProdutos> listaPedidoProdutos = service.findAllPedidosProdutos();
		listaPedidos.forEach(pedido -> {
			pedido.setListaProdutos((ArrayList<Produto>) listaPedidoProdutos.stream().map(pedidoProduto -> 
				produtoService.findById(pedidoProduto.getProduto().getId()).orElse(null))
				.collect(Collectors.toList()));
		});
		return listaPedidos;
	}
	
	
	@CrossOrigin 
	@PostMapping(value="/pedidos/salvar")
	public void findAllPedidos(@RequestBody JSONObject jsonPedido) {
		try {
			Pedido pedido = service.salvarPedido(jsonPedido);
			service.salvarProdutosPedido(pedido, jsonPedido);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}