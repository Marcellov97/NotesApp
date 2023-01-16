import {Component, OnInit} from '@angular/core';
import {Post} from "../../model/post";
import {PostService} from "../../service/post.service";
import { NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {Utente} from "../../model/utente";
import {AppStateService} from "../../service/app-state.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})


export class HomeComponent implements OnInit {

  //VARIABILI

  posts : Post[] = [];
  utenteLogged : Utente = {
    cognome: "", email: "", id: "", moderatore: false, nome: "", nomeUtente: "", password: ""
  }

  ordinamenti : string[] = [
    'valutazione',
    'utente',
    'descrizione'
  ]

  //*****************************************************************************************
  //METODI

  constructor(private postService : PostService, private router: Router, private appState : AppStateService) {
  }

  getPosts():void {
    this.postService.getAllPosts().subscribe((data:Post[])=>{
      this.posts=data;
    })
  }
  ngOnInit(): void {
    this.getPosts();
    this.posts.sort((a,b) => (a.valutazione > b.valutazione) ? 1 : ((b.valutazione > a.valutazione) ? -1 : 0));
    this.utenteLogged.nome = <string>this.appState.getNome();
    this.utenteLogged.cognome = <string>this.appState.getCognome();
    this.utenteLogged.nomeUtente = <string>this.appState.getNomeUtente();
    this.utenteLogged.id = <string>this.appState.getID();
    this.utenteLogged.email = <string>this.appState.getMail();

  }



  logout() {
    this.appState.clearAll();
    this.router.navigate(['/login']);

  }

  sorting(f : NgForm){
    this.posts.sort((a,b) => (a.nomeUtente > b.nomeUtente) ? 1 : ((b.nomeUtente > a.nomeUtente) ? -1 : 0));
  }

  searchPost(f : NgForm){
    //TODO fare richiesta HTTP e aggiornare l'elenco dei post
  }
}
