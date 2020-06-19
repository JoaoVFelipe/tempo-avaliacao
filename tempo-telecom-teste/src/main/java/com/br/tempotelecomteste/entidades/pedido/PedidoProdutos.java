package com.br.tempotelecomteste.entidades.pedido;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.br.tempotelecomteste.entidades.produto.Produto;

@Entity
@Table(name="PEDIDOS_X_PRODUTOS")
public class PedidoProdutos implements Serializable{
	
	private static final long serialVersionUID = 8525990874292163619L;

	@EmbeddedId
	private PedidoId id;
	
	
    @MapsId("produtoId") //references EmbeddedId's property
    @JoinColumn(name="PRODUTO_ID", referencedColumnName = "id")
    @ManyToOne
	private Produto produtoId;
    
    @MapsId("pedidoId") //references EmbeddedId's property
    @JoinColumn(name="PEDIDO_ID", referencedColumnName = "id")
    @ManyToOne
	private Pedido pedidoId;
    
	
	public PedidoProdutos() {
		super();
	}

	public PedidoProdutos(PedidoId id) {
		super();
		this.id = id;
	}

	
	public PedidoId getId() {
		return id;
	}

	public void setId(PedidoId id) {
		this.id = id;
	}

	public Produto getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}
	
}
