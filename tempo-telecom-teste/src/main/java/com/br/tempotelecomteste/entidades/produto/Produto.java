package com.br.tempotelecomteste.entidades.produto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="PRODUTOS")
public class Produto implements Serializable{
	@Id
	@GeneratedValue(generator="produto_gen")
	@SequenceGenerator(name="produto_gen",sequenceName="PRODUTO_ID_SEQ")
	private Long id;
	
	@Column(name= "NOME")
	private String nome;	

	@Column(name= "VALOR")
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}	

}
