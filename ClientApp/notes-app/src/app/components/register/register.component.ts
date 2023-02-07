import {Component, OnInit} from '@angular/core';
import {Utente} from "../../model/utente";
import {UtenteService} from "../../service/utente.service";
import { NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {AppStateService} from "../../service/app-state.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{

  utente : Utente = {    id : '77',   //questa variabile è inzializzata perchè deve avere un valore all'inzio
    nome : 'Kvicha',                  //poi viene sovrascitta quando si fa la registrazione
    cognome : 'Kvaraskhelia',
    nomeUtente : 'campione',
    email : 'kiv.partenopeo@napoli.it',
    password : 'fozzanapolisempre',
    moderatore : true};

  prop = '';


  constructor(private utenteService : UtenteService, private router : Router, private appState : AppStateService) {
  }

  ngOnInit(): void {
    this.appState.setLogged(false);
  }

  registerFunc(f : NgForm){
    this.utenteService.getUtente(f.value.nomeUtente).subscribe((data: Utente) => {
      if(data.nomeUtente == "") {
        this.utente.nome = f.value.nome;
        this.utente.cognome = f.value.cognome;
        this.utente.nomeUtente = f.value.nomeUtente;
        this.utente.email = f.value.email;
        this.utente.password = f.value.password;
        this.utente.moderatore = false;

        this.utenteService.setUtente(this.utente).subscribe((data: Utente) => {
          this.utente = data;
        });

        this.router.navigate(['/login']);
      } else {
        this.prop = "NomeUtente già esistente";
      }
    });
  }



}
