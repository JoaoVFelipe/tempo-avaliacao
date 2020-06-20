import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProdutosService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-produto',
  templateUrl: 'produto.component.html',
  styleUrls: ['produto.component.css']
})
export class ProdutoComponent {
  listaProdutos: Produto[];

  constructor(private router: Router, private produtoService: ProdutosService) {
    this.getProdutos();
  }

  getProdutos() {
    this.produtoService.getProdutos().subscribe((produtos: Produto[]) => {
      this.listaProdutos = produtos;
    });
  }

  abrirPaginaCadastro(){
    this.router.navigate(['/produtos/cadastro'])
  }
}
