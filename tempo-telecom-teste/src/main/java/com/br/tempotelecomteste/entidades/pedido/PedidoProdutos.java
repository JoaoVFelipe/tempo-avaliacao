package com.br.tempotelecomteste.entidades.pedido;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.br.tempotelecomteste.entidades.produto.Produto;

@Entity
@Table(name="PEDIDOS_X_PRODUTOS")
public class PedidoProdutos implements Serializable{
	
	@EmbeddedId
	private PedidoId id;
	
    @MapsId("produtoId") //references EmbeddedId's property
    @JoinColumn(name="PRODUTO_ID", referencedColumnName = "id")
    @ManyToMany
	private Produto produtoId;
	
}
