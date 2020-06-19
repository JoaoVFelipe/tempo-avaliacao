package com.br.tempotelecomteste.repositorios;
import org.springframework.data.repository.CrudRepository;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.entidades.produto.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
		

	

}
