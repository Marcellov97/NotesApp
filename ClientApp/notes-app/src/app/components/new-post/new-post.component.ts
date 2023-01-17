import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";
import {AppStateService} from "../../service/app-state.service";
import {Categorie} from "src/app/shared/categorie";
import * as events from "events";
@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.scss']
})
export class NewPostComponent implements OnInit{
  categs : string[] = [
    'video',
    'appunti',
    'esercizi',
    'esercizi svolti',
    'risultati esercizi'
  ]
  
  newPost : Post = {
    categoria: [],
    descrizione: "", id: "", nomeUtente: "", segnalato: false, valutazione: 0
  }

  categoriaSelected : string = ''


  constructor(private postService : PostService, private appState : AppStateService) {
  }

  postMessage(f : NgForm){
    this.newPost.nomeUtente = <string>this.appState.getNomeUtente();
    this.newPost.descrizione = f.value.message;
    this.newPost.categoria.push(this.categoriaSelected);

    this.postService.setPost(this.newPost).subscribe();

    window.location.reload();
  }

  changeCategoria(data : string){
    this.categoriaSelected = data;
  }

  ngOnInit(): void {

  }
}
