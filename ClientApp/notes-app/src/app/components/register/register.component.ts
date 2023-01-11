import {Component, OnInit} from '@angular/core';
import {Utente} from "../../model/utente";
import {UtenteService} from "../../service/utente.service";
import {Form} from "@angular/forms";
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


  constructor(private utenteService : UtenteService, private router : Router) {
  }

  ngOnInit(): void {
  }

  registerFunc(f : Form){
    
  }

}
