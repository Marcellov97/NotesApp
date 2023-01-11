import {Component, OnInit} from '@angular/core';
import {Utente} from "../../model/utente";
import {UtenteService} from "../../service/utente.service";
import { NgForm} from "@angular/forms";
import {Router} from "@angular/router";

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


  constructor(private utenteService : UtenteService, private router : Router) {
  }

  ngOnInit(): void {
  }

  registerFunc(f : NgForm){
    //TODO fare un controllo se nel database già esiste un nome utente uguale

    this.utente.nome = f.value.nome;
    this.utente.cognome = f.value.cognome;
    this.utente.nomeUtente = f.value.nickname;
    this.utente.email = f.value.email;
    this.utente.password = f.value.password;
    this.utente.moderatore = false;
    this.prop = 'qualcosa non va'
  }

}
