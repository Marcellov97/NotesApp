import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UtenteService} from "../../service/utente.service";
import {Utente} from "../../model/utente";
import {Route, Router, RouterModule} from "@angular/router";
import {AppStateService} from "../../service/app-state.service";

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

  prop = '';


  //****************************************************************
  //METODI

  constructor(private utenteService : UtenteService, private router : Router, private appState : AppStateService) {
  }
  ngOnInit(): void{

    this.appState.setLogged(false);

  }

  //FUNZIONE PER EFFETTUARE IL LOGIN
  login(form: NgForm):void {
    //raccolgo l'utente equivalente dal server
    this.utenteService.getUtente(form.value.nickname).subscribe((data: Utente) => {
      this.utente = data; //salvo l'utente nella variabile
      this.access = this.controlPassword(form.value.password);  //richiamo la funzione controlla password

      if(this.access){
        this.appState.setUtenteLogged(this.utente);
        this.router.navigate(['/home']);
      }else{
        this.prop = 'Accesso Negato';
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

    this.router.navigate(['/registration']);

  }
}
