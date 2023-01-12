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
  //selectedPost? : Post;
  posts : Post[] = [];
  utenteLogged : Utente = {
    cognome: "", email: "", id: "", moderatore: false, nome: "", nomeUtente: "", password: ""
  }

  constructor(private postService : PostService, private router: Router, private appState : AppStateService) {
  }

  getPosts():void {
    this.postService.getAllPosts().subscribe((data:Post[])=>{
      this.posts=data;
    })
  }
  ngOnInit(): void {
    this.getPosts();
    this.utenteLogged = this.appState.getUtenteLogged();
  }


  postMessage(form: any) {

  }

  logout() {
    this.router.navigate(['/login']);

  }
}
