import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Post} from "../model/post";
import {Valutazione} from "../model/valutazione";

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
    return this.http.get<Post[]>(this.postURL + '/getPostsUtente/' + nomeUtente)
  }

  getPostByCategoria(categoria : string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getPostsCategoria/' + categoria)
  }


  setPost(post: Post): Observable<unknown>{
    return this.http.post<Post>(this.postURL, post)
  }

  updatePostValutazione(data : Valutazione) : Observable<unknown>{
    return this.http.put(this.postURL + '/updatePostValutazione/' + data.idPost + '/' + data.valutazione.toString() + '/' + data.nomeUtente, data);
  }


  //TODO da testare
  deletePost(id: string): Observable<unknown>{
    return this.http.delete(this.postURL + '/deletePost/' + id)
  }
}
