package com.br.tempotelecomteste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.repositorios.PedidoProdutosRepository;
import com.br.tempotelecomteste.repositorios.PedidoRepository;

@Service
public class PedidosService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoProdutosRepository pedidosProdutosRepository;
}
