import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable, of } from 'rxjs';
import {Utente} from "../model/utente";
import {UTENTI} from "../DB-fake-utenti";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  private utentiURL = 'http://localhost:8080/api/utente';  //url dell'api del server

  constructor( private http: HttpClient) { }


  getAllUtenti(): Observable<Utente[]>{
    const allUtenti = of(UTENTI);
    return allUtenti;
  }

  getUtente(): Observable<Utente>{
    return this.http.get<Utente>(this.utentiURL)
  }
  

}
