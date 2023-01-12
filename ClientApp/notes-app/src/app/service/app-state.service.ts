import { Injectable } from '@angular/core';
import {Utente} from "../model/utente";

@Injectable({
  providedIn: 'root'
})
export class AppStateService {

  //VARIABILI

  private utente : Utente = {
    cognome: "", email: "", id: "", moderatore: false, nome: "", nomeUtente: "", password: ""
  }

  private logged : boolean = false;

  //*************************************************
  //METODI

  constructor() { }

  getUtenteLogged(): Utente{
    return this.utente
  }

  setUtenteLogged(dato : Utente){
    this.utente = dato;
  }

  isLogged():boolean{
    return this.logged;
  }

  setLogged(cond : boolean){
    this.logged = cond;
  }
}
