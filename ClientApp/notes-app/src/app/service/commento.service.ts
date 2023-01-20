import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Commento } from "../model/commento";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CommentoService {

  private URL = 'http://localhost:8080/commento';

  constructor(private http: HttpClient) { }

  //********************************************************
  //METODI HTTP COMMENTO
  //TODO tutti i metodi sono da testare

  getCommentiByPost(idPost : string): Observable<Commento[]>{
    return this.http.get<Commento[]>(this.URL + '/getCommentiPost/' + idPost)
  }

  setCommento(commento : Commento): Observable<unknown>{
    return this.http.post<Commento>(this.URL, commento)
  }

  deleteCommento(id: string): Observable<unknown>{
    return this.http.delete(this.URL + '/deleteCommento/' + id)
  }

  deleteCommentiByPost(idPost : string): Observable<unknown>{
    return this.http.delete(this.URL + '/deleteCommentiPost/' + idPost)
  }


}
