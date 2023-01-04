import { Component, OnInit } from '@angular/core';
import { Utente} from "../model/utente";
import { UtenteService} from "../service/utente.service";

@Component({
  selector: 'app-utente', //nome per selezionare questo componente
  templateUrl: './utente.component.html', //template in HTML del componente
  styleUrls: ['./utente.component.css'] //stile del componente in CSS
})

export class UtenteComponent implements OnInit{

  selectedUtente? : Utente;

  UTENTI : Utente[] = []
  utenteSingle?: Utente;

  constructor(private utenteService: UtenteService) {
  }

  ngOnInit(): void{
    this.getUtente();
    this.getAllUtenti();
  }

  onSelect(utente: Utente): void{
    this.selectedUtente = utente;
  }

  getAllUtenti(): void{
    this.utenteService.getAllUtenti().subscribe(utenti => this.UTENTI = utenti)
  }

  getUtente(): void{
    this.utenteService.getUtente().subscribe((data: Utente) => this.utenteSingle = {
      id : data.id,
      nome : data.nome,
      cognome : data.cognome,
      nomeUtente : data.nomeUtente,
      email : data.email,
      password : data.password,
      moderatore : data.moderatore,
    })
  }

}
