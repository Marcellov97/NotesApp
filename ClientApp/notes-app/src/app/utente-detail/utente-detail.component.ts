import { Component, Input } from '@angular/core';
import { Utente} from "../model/utente";

@Component({
  selector: 'app-utente-detail',
  templateUrl: './utente-detail.component.html',
  styleUrls: ['./utente-detail.component.css']
})
export class UtenteDetailComponent {

  //creo la variabile utente che viene data a questo componente e che il componente deve visualizzare
  //è una variabile opzionale (?) e di Input

  @Input() utente?: Utente;

}
