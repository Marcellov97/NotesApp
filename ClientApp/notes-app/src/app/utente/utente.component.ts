import { Component } from '@angular/core';
import { Utente} from "../model/utente";

@Component({
  selector: 'app-utente', //nome per selezionare questo componente
  templateUrl: './utente.component.html', //template in HTML del componente
  styleUrls: ['./utente.component.css'] //stile del componente in CSS
})

export class UtenteComponent {

  selectedUtente? : Utente;

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
      moderatore : true}
  ]

  onSelect(utente: Utente): void{
    this.selectedUtente = utente;
  }

}
