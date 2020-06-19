package com.br.tempotelecomteste.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Optional;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.pedido.Pedido;
import com.br.tempotelecomteste.entidades.pedido.PedidoId;
import com.br.tempotelecomteste.entidades.pedido.PedidoProdutos;
import com.br.tempotelecomteste.entidades.produto.Produto;
import com.br.tempotelecomteste.repositorios.PedidoProdutosRepository;
import com.br.tempotelecomteste.repositorios.PedidoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

@Service
public class PedidosService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoProdutosRepository pedidoProdutosRepository;
	
	@Transactional
	public ArrayList<Pedido> findAllPedidos() {
		return (ArrayList<Pedido>) repository.findAll();
	}
	
	@Transactional
	public Optional<PedidoProdutos> findPedidoProdutoById(PedidoId id) {
		return pedidoProdutosRepository.findById(id);
	}
	
	@Transactional
	public ArrayList<PedidoProdutos> findAllPedidosProdutos() {
		return (ArrayList<PedidoProdutos>) pedidoProdutosRepository.findAll();
	}
	
	@Transactional
	public Pedido salvarPedido(JSONObject jsonPedido) throws ParseException {
		Pedido pedido = new Pedido();
		
		LocalDate now = LocalDate.now(); 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = formato.parse(String.valueOf(now.getDayOfMonth()) + "/" + String.valueOf(now.getMonthValue()) + "/"+ String.valueOf(now.getYear())); 
		pedido.setData(dataFormatada);
		
		LocalTime nowTime = LocalTime.now();
		pedido.setHora(String.valueOf(nowTime.getHour()) + ":" + String.valueOf(nowTime.getMinute()));
		
		pedido.setValor((Double) jsonPedido.get("valor"));
		
		ObjectMapper mapper = new ObjectMapper();
		pedido.setCliente(mapper.convertValue(jsonPedido.get("cliente"), Cliente.class));
		return repository.save(pedido);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public void salvarProdutosPedido(Pedido pedido, JSONObject jsonPedido) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<PedidoProdutos> listPedidoProduto = new ArrayList<>();
		ArrayList<LinkedHashMap> listProdutos = (ArrayList<LinkedHashMap>) jsonPedido.get("produtos");
		
		listProdutos.forEach(jsonProduto -> {
			PedidoProdutos pedidoProdutos = new PedidoProdutos();
			Produto produto = mapper.convertValue(jsonProduto, Produto.class);
			PedidoId pedidoId = new PedidoId(pedido.getId(), produto.getId());
			
			pedidoProdutos.setId(pedidoId);
			pedidoProdutos.setPedido(pedido);
			pedidoProdutos.setProduto(produto);
			
			listPedidoProduto.add(pedidoProdutos);
		});
		
		pedidoProdutosRepository.saveAll(listPedidoProduto);
		
	}



}
