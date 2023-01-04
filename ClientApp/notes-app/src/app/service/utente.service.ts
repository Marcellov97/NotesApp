import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable, of } from 'rxjs';
import {Utente} from "../model/utente";
import {UTENTI} from "./DB-fake-utenti";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {



  constructor( private http: HttpClient) { }


  getAllUtenti(): Observable<Utente[]>{
    const allUtenti = of(UTENTI);
    return allUtenti;
  }

  getUtente(): Observable<Utente>{
    const utente = of(UTENTI[0]);
    return utente;
  }


}
