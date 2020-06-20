import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopMenuComponent } from './components/top-menu/top.menu.component';
import { HomeComponent } from './pages/home/home.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { PedidoComponent } from './pages/pedido/pedido.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import { PedidoCadastroComponent } from './pages/pedido/pedido-cadastro/pedido.cadastro.component';
import { ProdutoComponent } from './pages/produto/produto.component';
import { ClienteCadastroComponent } from './pages/cliente/cliente-cadastro/cliente.cadastro.component';
import { ProdutoCadastroComponent } from './pages/produto/produto-cadastro/produto.cadastro.component';


@NgModule({
  declarations: [
    AppComponent,
    TopMenuComponent,
    HomeComponent,
    ClienteComponent,
    PedidoComponent,
    ProdutoComponent,
    ClienteCadastroComponent,
    ProdutoCadastroComponent,
    PedidoCadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
