package com.br.tempotelecomteste.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.entidades.pedido.Pedido;
import com.br.tempotelecomteste.repositorios.PedidoProdutosRepository;
import com.br.tempotelecomteste.repositorios.PedidoRepository;

@Service
public class PedidosService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoProdutosRepository pedidosProdutosRepository;

	@Transactional
	public ArrayList<Pedido> findAllPedidos() {
		return (ArrayList<Pedido>) repository.findAll();
	}
}
