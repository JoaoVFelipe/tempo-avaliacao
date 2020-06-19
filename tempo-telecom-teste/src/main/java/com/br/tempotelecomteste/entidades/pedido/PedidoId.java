package com.br.tempotelecomteste.entidades.pedido;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoId implements Serializable {
	private static final long serialVersionUID = -5472198536275111382L;
	
	@Column(name = "PEDIDO_ID")
	private Long pedidoId;
	@Column(name = "PRODUTO_ID")
	private Long produtoId;
	
	 public PedidoId() {
		 super();
	 }
	
	 public PedidoId(Long pedidoId, Long produtoId) {
		 this.pedidoId = pedidoId;
	     this.produtoId = produtoId;
	 }

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	 
}
