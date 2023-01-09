import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Observable} from "rxjs";
import {Valutazione} from "../model/valutazione";

@Injectable({
  providedIn: 'root'
})
export class ValutazioneService {

  private URL = 'http://localhost:8080/valutazione';

  constructor(private http : HttpClient) { }

  //***************************************************
  //METODI HTTP VALUTAZIONE
  //TODO tutti i metodi sono da testare

  getValutazioniByPost(idPost : string): Observable<Valutazione>{
    return this.http.get<Valutazione>(this.URL + '/getValutazioniPost/' + idPost)
  }

  setValutazione(valutazione : Valutazione): Observable<Valutazione>{
    return this.http.post<Valutazione>(this.URL, valutazione)
  }

  deleteValutazione(id : string): Observable<unknown>{
    return this.http.delete(this.URL + '/deleteValutazione/' + id)
  }

  deleteValutazioniByPost(idPost : string): Observable<unknown>{
    return this.http.delete(this.URL + '/deleteValutazioniPost/' + idPost)
  }
}
