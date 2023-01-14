import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PostService} from "../../service/post.service";
import {Post} from "../../model/post";
import {AppStateService} from "../../service/app-state.service";

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.css']
})
export class NewPostComponent implements OnInit{

  newPost : Post = {
    descrizione: "", id: "", nomeUtente: "", segnalato: false, valutazione: 0
  }


  constructor(private postService : PostService, private appState : AppStateService) {
  }

  postMessage(f : NgForm){
    this.newPost.nomeUtente = <string>this.appState.getNomeUtente();
    this.newPost.descrizione = f.value.message;

    this.postService.setPost(this.newPost).subscribe();

    window.location.reload();
  }

  ngOnInit(): void {
  }
}
