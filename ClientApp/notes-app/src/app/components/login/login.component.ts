import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UtenteService} from "../../service/utente.service";
import {Utente} from "../../model/utente";
import {Route, Router, RouterModule} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //VARIABILI

  utente : Utente = {    id : '77',   //questa variabile è inzializzata perchè deve avere un valore all'inzio
    nome : 'Kvicha',                  //poi viene sovrascitta quando si fa il login
    cognome : 'Kvaraskhelia',
    nomeUtente : 'campione',
    email : 'kiv.partenopeo@napoli.it',
    password : 'fozzanapolisempre',
    moderatore : true};

  private access : boolean = false;

  prop = ''; //TODO rimuovere questa variabile


  //****************************************************************
  //METODI

  constructor(private utenteService : UtenteService, private router : Router) {
  }
  ngOnInit(): void{

  }

  //FUNZIONE PER EFFETTUARE IL LOGIN
  login(form: NgForm):void {
    //raccolgo l'utente equivalente dal server
    this.utenteService.getUtente(form.value.nickname).subscribe((data: Utente) => {
      this.utente = data; //salvo l'utente nella variabile
      this.access = this.controlPassword(form.value.password);  //richiamo la funzione controlla password

      if(this.access){
        this.prop = 'loggato';
        //TODO qua bisogna mettere come url /home alla pagina home
        this.router.navigate(['/home']);
      }else{
        this.prop = 'accesso negato';
        //TODO scrivere da qualche parte che l'accesso è negato
      }
    })
  }

  //FUNZIONE PER CONTROLLARE LA PASSWORD INSERITA
  private controlPassword(pw : string): boolean{

    //se la password che è stata scritta è uguale a quella salvata nel server per l'utente allora entra
    if(pw == this.utente.password){
      return true;
    }else{
      return false;
    }
  }

  //FUNZIONE PER APRIRE LA PAGINA DI REGISTRAZIONE
  openRegister():void {

    //TODO bisogna inserire nel routing-module il path per la pagina di registrazione
    this.router.navigate(['/registration']);

  }
}
