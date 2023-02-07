import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable, of , map} from 'rxjs';
import {Utente} from "../model/utente";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  private utenteURL = 'http://localhost:8080/utente'; //URL del Controller Utente


  constructor( private http: HttpClient) { }


  //*****************************************************
  //SERVIZI HTTP UTENTE

  getAllUtenti(): Observable<Utente[]>{
    return this.http.get<Utente[]>(this.utenteURL+'/getAllUtenti')
  }

  /*
  getUtente(nomeUtente : string): Observable<Utente>{
    return this.http.get<Utente>(this.utenteURL + '/getUtente/' + nomeUtente)
  }*/

  getUtente(nomeUtente : string): Observable<Utente>{
    return this.http.get<Utente>(this.utenteURL + '/getUtente/' + nomeUtente);
  }




  //TODO da testare
  setUtente(utente: Utente): Observable<Utente>{
    return this.http.post<Utente>(this.utenteURL, utente)
  }

  //TODO da testare
  deleteUtente(nomeUtente: string): Observable<unknown>{
    return this.http.delete(this.utenteURL + '/deleteUtente/' + nomeUtente)
  }


}
