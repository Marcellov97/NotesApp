import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable, of } from 'rxjs';
import {Utente} from "../model/utente";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  private utenteURL = 'http://localhost:8080/utente'; //URL del Controller Utente


  constructor( private http: HttpClient) { }


  getAllUtenti(): Observable<Utente[]>{
    return this.http.get<Utente[]>(this.utenteURL+'/getAllUtenti')
  }

  getUtente(nomeUtente : string): Observable<Utente>{
    return this.http.get<Utente>(this.utenteURL + '/getUtente/' + nomeUtente)
  }


}
