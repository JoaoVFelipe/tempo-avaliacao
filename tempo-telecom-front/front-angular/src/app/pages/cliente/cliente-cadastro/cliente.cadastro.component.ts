import { Component } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-cliente-cadastro',
  templateUrl: 'cliente.cadastro.component.html',
  styleUrls: ['cliente.cadastro.component.css']
})
export class ClienteCadastroComponent {
  nomeCliente: any;
  nascimentoCliente: any;
  telefoneCliente: any;

  constructor(private clienteService: ClienteService) {
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
    this.clienteService.salvarClientes(cliente).subscribe();
  }
  cancelarSalvar(){}
}
