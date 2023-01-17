import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Post} from "../model/post";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postURL = 'http://localhost:8080/post'

  constructor(private http : HttpClient) { }

  //****************************************************************
  //SERVIZI HTTP POST

  getAllPosts(): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getAllPosts')
  }

  //TODO da testare
  getPostsByString(parola : string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getPostsString/' + parola)
  }

  getPostsbyValutazione(valutazione : string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getPostsValutazione/' + valutazione)
  }

  getPostsbyUtente(nomeUtente: string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + 'getPostsUtente/' + nomeUtente)
  }


  setPost(post: Post): Observable<Post>{
    return this.http.post<Post>(this.postURL, post)
  }

  //TODO qua bisogna fare le update


  //TODO da testare
  deletePost(id: string): Observable<unknown>{
    return this.http.delete(this.postURL + '/deletePost/' + id)
  }
}
