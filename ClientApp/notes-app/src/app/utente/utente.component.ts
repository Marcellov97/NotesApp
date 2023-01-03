import { Component, OnInit } from '@angular/core';
import { Utente} from "../model/utente";
import { UtenteService} from "../utente.service";

@Component({
  selector: 'app-utente', //nome per selezionare questo componente
  templateUrl: './utente.component.html', //template in HTML del componente
  styleUrls: ['./utente.component.css'] //stile del componente in CSS
})

export class UtenteComponent {

  selectedUtente? : Utente;

  UTENTI : Utente[] = []

  constructor(private utenteService: UtenteService) {
  }

  ngOnInit(): void{
    this.getAllUtenti();
  }

  onSelect(utente: Utente): void{
    this.selectedUtente = utente;
  }

  getAllUtenti(): void{
    this.utenteService.getAllUtenti().subscribe(utenti => this.UTENTI = utenti)
  }

}
