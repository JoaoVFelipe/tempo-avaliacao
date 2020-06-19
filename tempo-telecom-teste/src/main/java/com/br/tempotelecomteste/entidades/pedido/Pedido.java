package com.br.tempotelecomteste.entidades.pedido;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.produto.Produto;


@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente clienteId;
	
	@Column(name= "DATA")
	private Date data;
	
	@Column(name= "HORA")
	private String hora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	
}
