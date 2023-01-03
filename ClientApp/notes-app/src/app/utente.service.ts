import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Utente} from "./model/utente";
import {UTENTI} from "./DB-fake-utenti";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor() { }

/*
  getAllUtenti(): Utente[]{
    return UTENTI;
  }*/


  getAllUtenti(): Observable<Utente[]>{
    const allUtenti = of(UTENTI);
    return allUtenti;
  }

}
