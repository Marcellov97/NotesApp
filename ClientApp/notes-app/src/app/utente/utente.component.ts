import { Component } from '@angular/core';
import { Utente} from "./model/utente";

@Component({
  selector: 'app-utente',
  templateUrl: './utente.component.html',
  styleUrls: ['./utente.component.css']
})
export class UtenteComponent {

  utente : Utente = {
    id : '1',
    nome : 'Riccardo',
    cognome : 'Malato',
    nomeUtente : 'RickSick74',
    email : 'rik.partenopeo@napoli.it',
    password : 'fozzanapolisempre',
    moderatore : true
  }

}
