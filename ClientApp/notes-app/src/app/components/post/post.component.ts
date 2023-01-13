import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../model/post";
import {CommentoService} from "../../service/commento.service";
import {Commento} from "../../model/commento";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit{

  @Input() post : Post = {descrizione: "", id: "", nomeUtente: "", segnalato: false, valutazione: 0};

  commenti : Commento[] = [];


  constructor(private commentoService : CommentoService) {
  }

  ngOnInit(): void {
    this.commentoService.getCommentiByPost(this.post.id).subscribe((data : Commento[]) => {
      this.commenti = data;
    })

  }



}
