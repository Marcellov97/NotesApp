import { Injectable } from '@angular/core';
import {Utente} from "../model/utente";

@Injectable({
  providedIn: 'root'
})
export class AppStateService {

  //VARIABILI


  private utente : Utente = {
    cognome: "", email: "", id: "idprova", moderatore: false, nome: "", nomeUtente: "", password: ""
  }

  private logged : boolean = false;

  //*************************************************
  //METODI

  constructor() { }

  getNome(): string | null {
    return localStorage.getItem("nomeLogged")
  }

  getCognome(): string | null {
    return localStorage.getItem("cognomeLogged")
  }

  getNomeUtente(): string | null {
    return localStorage.getItem("nomeUtenteLogged")
  }

  getID(): string | null{
    return localStorage.getItem("idLogged")
  }

  getMail(): string | null{
    return localStorage.getItem("mailLogged")
  }



  setUtenteLogged(dato : Utente){
    localStorage.setItem("nomeLogged", dato.nome);
    localStorage.setItem("cognomeLogged", dato.cognome);
    localStorage.setItem("idLogged", dato.id);
    localStorage.setItem("nomeUtenteLogged", dato.nomeUtente);
    localStorage.setItem("mailLogged", dato.email);
    localStorage.setItem("password", dato.password);
  }

  isLogged():boolean{
    return this.logged;
  }

  setLogged(cond : boolean){
    this.logged = cond;
  }

  clearAll(){
    localStorage.clear();
  }

}
