import { Component } from '@angular/core';
import { ProdutosService } from 'src/app/services/produto.service';
import { Produto } from 'src/app/models/produto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produto-cadastro',
  templateUrl: 'produto.cadastro.component.html',
  styleUrls: ['produto.cadastro.component.css']
})
export class ProdutoCadastroComponent {
  nomeProduto: any;
  valorProduto: any;

  showErro =  false;
  erroDetalhe = '';
  showSucess =  false;
  constructor(private router: Router, private produtoService: ProdutosService) {
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
    this.produtoService.salvarProduto(produto).subscribe( 
      (pedido) => {
        if(pedido != null){
          this.showSucessBar();
          this.limpaProduto();
        }
        else{
          this.showErroBar("Erro ao tentar salvar o produto. Verifique os campos e tente novamente");
        }
      },
        (error) => this.showErroBar("Erro ao tentar salvar o produto. " + error)
    );
  }

  cancelarSalvar(){
    this.limpaProduto();
    this.router.navigate(['/produtos'])
  }

  limpaProduto(){
    this.nomeProduto = null;
    this.valorProduto = null;
  }

  showSucessBar(){
    this.dismissErro();
    this.showSucess = true;
  }

  dismissSucesso(){
    this.showSucess = false;
  }

  showErroBar(detalhe){
    this.dismissSucesso();
    this.showErro = true;
    this.erroDetalhe = detalhe;
  }

  dismissErro(){
    this.showErro = false;
    this.erroDetalhe = "";
  }
}
