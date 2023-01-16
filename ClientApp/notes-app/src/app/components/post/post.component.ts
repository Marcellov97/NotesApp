import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../model/post";
import {CommentoService} from "../../service/commento.service";
import {Commento} from "../../model/commento";
import {AppStateService} from "../../service/app-state.service";
import { NgForm } from '@angular/forms';
import {ValutazioneService} from "../../service/valutazione.service";
import {Valutazione} from "../../model/valutazione";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit{

  @Input() post : Post = {descrizione: "", id: "", nomeUtente: "", segnalato: false, valutazione: 0};
  commentiActived : boolean = false;
  commenti : Commento[] = [];

  newCom : Commento = {
    id: "", idPost: "", nomeUtente: "", testo: ""
  };

  newVal : Valutazione = {idPost: "", idUtente: "", idValutazione: "", valutazione: 0};


  constructor(private commentoService : CommentoService, private appState : AppStateService, private valutazioneService : ValutazioneService) {
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

  activeCommenti() {
    if (this.commentiActived == false)
      this.commentiActived = true;
    else if (this.commentiActived == true)
      this.commentiActived = false;
  }

  valutaPost(val : number){
    this.newVal.idPost = this.post.id;
    this.newVal.idUtente = <string>this.appState.getID();
    this.newVal.valutazione = val;

    this.valutazioneService.setValutazione(this.newVal).subscribe();
  }


}
