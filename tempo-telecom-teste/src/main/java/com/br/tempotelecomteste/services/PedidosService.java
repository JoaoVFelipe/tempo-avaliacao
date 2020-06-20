package com.br.tempotelecomteste.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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

@Service
public class PedidosService {
	
	@Autowired
	PedidoRepository repository;
	
	@Autowired
	PedidoProdutosRepository pedidoProdutosRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	/**
	 * Busca todos os pedidos  e todos os produtos relacionados a cada pedido
	 * 
	 * */
	@Transactional
	public ArrayList<Pedido> findAllPedidos() {
		//Busca todos os pedidos
		ArrayList<Pedido> listaPedidos = (ArrayList<Pedido>) repository.findAll();
		//Busca todos os PedidoProduto
		ArrayList<PedidoProdutos> listaPedidoProdutos = this.findAllPedidosProdutos();
		
		//Para cada pedido
		listaPedidos.forEach(pedido -> {
			//Seta a lista de produtos
			pedido.setListaProdutos((ArrayList<Produto>) listaPedidoProdutos.stream().
					//Se o id do pedido for o mesmo em pedido e em pedidoProduto
					filter(pedidoProduto -> 
						pedidoProduto.getPedido().getId().equals(pedido.getId()))
					//Com os dados de produto encontrado na busca
					.map(pedidoProduto ->
						produtoService.findById(pedidoProduto.getProduto().getId()).orElse(null))
				.collect(Collectors.toList()));
		});
		return listaPedidos;
	}
	

	/**
	 * Busca todos os pedidosxProdutos
	 * 
	 * */
	@Transactional
	public ArrayList<PedidoProdutos> findAllPedidosProdutos() {
		return (ArrayList<PedidoProdutos>) pedidoProdutosRepository.findAll();
	}
	
	/**
	 * Salva pedido
	 * 
	 * @param jsonPedido
	 * 				JSONObject com os dados do pedido
	 * 
	 * @return pedido salvo em caso de sucesso, ou null em caso de erro
	 * 
	 * */
	@Transactional
	public Pedido salvarPedido(JSONObject jsonPedido) {
		Pedido pedido = new Pedido();
		try {
			//Busca data atual do sistema e a formata
			LocalDate now = LocalDate.now(); 
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date dataFormatada = formato.parse(String.valueOf(now.getDayOfMonth()) + "/" + String.valueOf(now.getMonthValue()) + "/"+ String.valueOf(now.getYear()));
			pedido.setData(dataFormatada);
			
			//Busca hora atual do sistema e a formata
			LocalTime nowTime = LocalTime.now();
			pedido.setHora(String.valueOf(nowTime.getHour()) + ":" + String.valueOf(nowTime.getMinute()));
			
			//Seta valor
			pedido.setValor(Double.valueOf(String.valueOf(jsonPedido.get("valor"))));
			
			//Seta Cliente
			ObjectMapper mapper = new ObjectMapper();
			pedido.setCliente(mapper.convertValue(jsonPedido.get("cliente"), Cliente.class));
			
			//Salva Pedido
			return repository.save(pedido);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public void salvarProdutosPedido(Pedido pedido, JSONObject jsonPedido) {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<PedidoProdutos> listPedidoProduto = new ArrayList<>();
		ArrayList<LinkedHashMap> listProdutos = (ArrayList<LinkedHashMap>) jsonPedido.get("produtos");
		
		if(pedido != null) {
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



}
