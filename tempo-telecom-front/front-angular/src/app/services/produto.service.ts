import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Produto } from '../models/produto';


@Injectable({
  providedIn: 'root',
})
export class ProdutosService {
    url = '';

    // Headers
    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }

    constructor(private httpClient: HttpClient) { 
        this.url = environment.BASE_URL;
    }
    // Obtem todos os produtos
    getProdutos(): Observable<any[]> {
        return this.httpClient.get<any>(this.url + "/produtos/all")
        .pipe(
          retry(2),
          catchError(this.handleError))
    }

    // Salva produtos
    salvarProduto(produto: Produto): Observable<Produto> {
        return this.httpClient.post<Produto>(this.url + "/produtos/salvar", JSON.stringify(produto), this.httpOptions)
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