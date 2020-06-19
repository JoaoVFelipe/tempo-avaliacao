import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Cliente } from '../models/cliente';
import { environment } from 'src/environments/environment';
import { Pedido } from '../models/pedido';


@Injectable({
  providedIn: 'root',
})
export class PedidosService {
    url = '';

    constructor(private httpClient: HttpClient) { 
        this.url = environment.BASE_URL;
    }

    // Headers
    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }

    // Obtem todos os pedidos
    getPedidos(): Observable<any[]> {
        return this.httpClient.get<any>(this.url + "/pedidos/all")
        .pipe(
          retry(2),
          catchError(this.handleError))
    }

    // Salva pedidos
    salvarPedido(pedido: Pedido): Observable<Pedido> {
        return this.httpClient.post<Pedido>(this.url + "/pedidos/salvar", JSON.stringify(pedido), this.httpOptions)
        .pipe(
            catchError(this.handleError)
        )
    }

    // Manipulação de erros
    handleError(error: HttpErrorResponse) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // Erro ocorreu no lado do client
            errorMessage = error.error.message;
        } else {
            // Erro ocorreu no lado do servidor
            errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
        }
        console.log(errorMessage);
        return throwError(errorMessage);
    };

    

}