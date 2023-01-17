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

  categoriaSelected : string = 'appunti'

  categs : string[] = [
    'appunti',
    'video',
    'esercizi',
    'esercizi svolti',
    'risultati esercizi'
  ]



  //*****************************************************************************************
  //METODI

  constructor(private postService : PostService, private router: Router, private appState : AppStateService) {

  }

  getPosts():void {
    this.postService.getPostByCategoria(this.categoriaSelected).subscribe((data : Post[]) => {
      this.posts = data;
    })
  }
  ngOnInit(): void {
    this.getPosts();
    this.sortPost();
    this.utenteLogged.nome = <string>this.appState.getNome();
    this.utenteLogged.cognome = <string>this.appState.getCognome();
    this.utenteLogged.nomeUtente = <string>this.appState.getNomeUtente();
    this.utenteLogged.id = <string>this.appState.getID();
    this.utenteLogged.email = <string>this.appState.getMail();
  }

  refreshPage(){
    window.location.reload();
  }

  sortPost(){
    this.posts.sort((a,b) => (a.valutazione > b.valutazione) ? 1 : ((b.valutazione > a.valutazione) ? -1 : 0));
  }



  logout() {
    this.appState.clearAll();
    this.router.navigate(['/login']);

  }



  searchPost(f : NgForm){

    //TODO fare richiesta HTTP e aggiornare l'elenco dei post
    this.postService.getPostsByString(f.value.key).subscribe((data : Post[]) => {
      this.posts = data;
    })
  }

  changeCategoria(x : string){
    this.categoriaSelected = x;
    this.getPosts();
  }
}
