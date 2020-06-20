import { Component } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-cadastro',
  templateUrl: 'cliente.cadastro.component.html',
  styleUrls: ['cliente.cadastro.component.css']
})
export class ClienteCadastroComponent {
  nomeCliente: any;
  nascimentoCliente: any;
  telefoneCliente: any;

  showErro =  false;
  erroDetalhe = '';
  showSucess =  false;

  constructor(private router: Router, private clienteService: ClienteService) {
  }

  cadastrarCliente(){
    var cliente: Cliente = {
      id: null,
      nome: this.nomeCliente,
      nascimento: this.nascimentoCliente,
      dataFormatada: '',
      telefone: this.telefoneCliente,
    } ;
    this.salvarCliente(cliente);
  }
  
  salvarCliente(cliente){
    this.clienteService.salvarClientes(cliente).subscribe( 
      (cliente) => {
        if(cliente != null){
          this.showSucessBar();
          this.limpaCliente();
        }
        else{
          this.showErroBar("Erro ao tentar salvar o cliente. Verifique os campos e tente novamente");
        }
      },
        (error) => this.showErroBar("Erro ao tentar salvar o cliente. " + error)
    );
  }
  cancelarSalvar(){
    this.limpaCliente();
    this.router.navigate(['/clientes'])
  }

  limpaCliente(){
    this.nomeCliente = null;
    this.nascimentoCliente = null;
    this.telefoneCliente = null;
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
