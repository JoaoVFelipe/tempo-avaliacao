package com.br.tempotelecomteste.entidades.cliente;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable{
	@Id
	@GeneratedValue(generator="cliente_gen")
	@SequenceGenerator(name="cliente_gen",sequenceName="CLIENTE_ID_SEQ")
	private Long id;
	
	@Column(name= "NOME")
	private String nome;	

	@Column(name= "TELEFONE")
	private String telefone;	
	
	@Column(name= "NASCIMENTO")
	private Date nascimento;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}	
	
	
}
