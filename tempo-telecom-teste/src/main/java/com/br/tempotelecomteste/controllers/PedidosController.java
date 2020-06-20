package com.br.tempotelecomteste.controllers;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.pedido.Pedido;
import com.br.tempotelecomteste.services.PedidosService;



@RestController
public class PedidosController {
	
	@Autowired
	PedidosService service;
	

	
	@CrossOrigin 
	@GetMapping(value="/pedidos/all")
	public ArrayList<Pedido> findAllPedidos() {
		return service.findAllPedidos();
	}
	
	
	@CrossOrigin 
	@PostMapping(value="/pedidos/salvar")
	public Pedido salvarPedido(@RequestBody JSONObject jsonPedido) {
		Pedido pedido = service.salvarPedido(jsonPedido);
		service.salvarProdutosPedido(pedido, jsonPedido);
		return pedido;
	}
	
	
	
	
	
	
	
}