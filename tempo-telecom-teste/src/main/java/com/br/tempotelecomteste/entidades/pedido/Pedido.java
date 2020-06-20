package com.br.tempotelecomteste.entidades.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.produto.Produto;


@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 3040249433965315189L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;
	
	@Column(name= "DATA")
	private Date data;
	
	@Column(name= "HORA")
	private String hora;
	
	@Column(name= "VALOR")
	private Double valor;
	
	@Transient
	private ArrayList<Produto> listaProdutos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente clienteId) {
		this.cliente = clienteId;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	
	
	
}
