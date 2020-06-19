package com.br.tempotelecomteste.controllers;

import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void findAllPedidos(@RequestBody JSONObject jsonPedido) {
		System.out.println("BATEU A REQUISICAO DE SALVAR");
		try {
			Pedido pedido = service.salvarPedido(jsonPedido);
			service.salvarProdutosPedido(pedido, jsonPedido);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}