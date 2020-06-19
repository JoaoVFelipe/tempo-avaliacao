package com.br.tempotelecomteste.repositorios;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.pedido.Pedido;
import com.br.tempotelecomteste.entidades.pedido.PedidoId;
import com.br.tempotelecomteste.entidades.pedido.PedidoProdutos;
import com.br.tempotelecomteste.entidades.produto.Produto;

public interface PedidoProdutosRepository extends CrudRepository<PedidoProdutos, PedidoId>{

	ArrayList<Produto> findProdutoByPedidoId(Long id);
		
}
