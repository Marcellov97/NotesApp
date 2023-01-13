import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../model/post";
import {CommentoService} from "../../service/commento.service";
import {Commento} from "../../model/commento";
import {AppStateService} from "../../service/app-state.service";
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit{

  @Input() post : Post = {descrizione: "", id: "", nomeUtente: "", segnalato: false, valutazione: 0};

  commenti : Commento[] = [];

  newCom : Commento = {
    id: "", idPost: "", nomeUtente: "", testo: ""
  }


  constructor(private commentoService : CommentoService, private appState : AppStateService) {
  }

  ngOnInit(): void {
    this.commentoService.getCommentiByPost(this.post.id).subscribe((data : Commento[]) => {
      this.commenti = data;
    })
  }

  myNickName(){
    return this.appState.getNomeUtente();
  }

  deleteCommento(id : string){
    this.commentoService.deleteCommento(id).subscribe();
    window.location.reload();
  }

  newCommento(f : NgForm, idP : string){
    this.newCom.idPost = idP;
    this.newCom.nomeUtente = <string>this.myNickName();
    this.newCom.testo = f.value.commento;

    this.commentoService.setCommento(this.newCom).subscribe();

    window.location.reload();
  }


}
