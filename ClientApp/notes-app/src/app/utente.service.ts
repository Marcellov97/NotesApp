import { Injectable } from '@angular/core';
import {Utente} from "./model/utente";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor() { }

  getAllUtenti(): Utente[]{
    return this.UTENTI;
  }

  UTENTI : Utente[] = [
    {    id : '1',
      nome : 'Riccardo',
      cognome : 'Malato',
      nomeUtente : 'RickSick74',
      email : 'rik.partenopeo@napoli.it',
      password : 'fozzanapolisempre',
      moderatore : true},
    {    id : '2',
      nome : 'Marcello',
      cognome : 'Vestri',
      nomeUtente : 'Marcellov97',
      email : 'ma.vestri@napoli.it',
      password : 'fozzanapolisempre',
      moderatore : false},
    {    id : '3',
      nome : 'Chiara',
      cognome : 'Paventa',
      nomeUtente : 'chiapav',
      email : 'chia@lilli.dog',
      password : 'lilli',
      moderatore : true},
    {    id : '4',
      nome : 'Michele',
      cognome : 'Viscardi',
      nomeUtente : 'Michelone25',
      email : 'mik.vis@milan.merda.it',
      password : 'fozzanapolisempre',
      moderatore : false}
  ]
}
