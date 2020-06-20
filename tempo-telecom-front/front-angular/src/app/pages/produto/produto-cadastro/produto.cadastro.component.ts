import { Component } from '@angular/core';
import { ProdutosService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-produto-cadastro',
  templateUrl: 'produto.cadastro.component.html',
  styleUrls: ['produto.cadastro.component.css']
})
export class ProdutoCadastroComponent {
  nomeProduto: any;
  valorProduto: any;

  constructor(private produtoService: ProdutosService) {
  }

  cadastrarProduto(){
    var produto: Produto = {
      id: null,
      nome: this.nomeProduto,
      valor: this.valorProduto,
    } ;
    this.salvarProduto(produto);
  }

  salvarProduto(produto){
    this.produtoService.salvarProduto(produto).subscribe();
  }
}
