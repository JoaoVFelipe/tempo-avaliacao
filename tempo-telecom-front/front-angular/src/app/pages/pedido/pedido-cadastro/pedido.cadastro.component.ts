import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ClienteService } from 'src/app/services/cliente.service';
import { ProdutosService } from 'src/app/services/produto.service';
import { Cliente } from 'src/app/models/cliente';
import { Produto } from 'src/app/models/produto';
import { Pedido } from 'src/app/models/pedido';
import { PedidosService } from 'src/app/services/pedidos.service';



@Component({
  selector: 'app-pedido-cadastro',
  templateUrl: 'pedido.cadastro.component.html',
  styleUrls: ['pedido.cadastro.component.css']
})
export class PedidoCadastroComponent implements OnInit{
  clientesList: Cliente[];
  produtoList: Produto[];

  produtoSelecionado: Produto;

  clientePedido: Cliente;
  produtoListPedido: Produto[] = [];
  valorPedido: number;

  constructor(private clienteService: ClienteService, private produtoService: ProdutosService, private pedidosService: PedidosService) {
    this.getClientes();
    this.getProdutos();
  }

  ngOnInit(){
  
  }

  getClientes() {
    this.clienteService.getClientes().subscribe((clientes: Cliente[]) => {
      this.clientesList = clientes;
    });
  }

  getProdutos() {
    this.produtoService.getProdutos().subscribe((produto: Produto[]) => {
      this.produtoList = produto;
    });
  }

  adicionarProduto(){
    if(this.produtoSelecionado){
      this.produtoListPedido.push(this.produtoSelecionado);
      this.calcValorPedido();
    }
  }

  calcValorPedido(){
    this.valorPedido = 0;
    this.produtoListPedido.forEach(produto => {
      this.valorPedido = this.valorPedido + produto.valor;
    })
  }

  cadastrarPedido(){
    var pedido: Pedido = {
      id: null,
      cliente: this.clientePedido,
      produtos: this.produtoListPedido,
      valor: this.valorPedido,
      data: '',
      hora: ''
    } ;
    this.salvarPedido(pedido);
  }

  salvarPedido(pedido){
    this.pedidosService.salvarPedido(pedido).subscribe((clientes) => {
    });
  }
}
