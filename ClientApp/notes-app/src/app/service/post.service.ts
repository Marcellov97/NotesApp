import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Post} from "../model/post";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postURL = 'http://localhost:8080/post'

  constructor(private http : HttpClient) { }

  getAllPosts(): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getAllPosts')
  }

  getPostsbyValutazione(valutazione : string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + '/getPostsValutazione/' + valutazione)
  }

  getPostsbyUtente(nomeUtente: string): Observable<Post[]>{
    return this.http.get<Post[]>(this.postURL + 'getPostsUtente/' + nomeUtente)
  }
}
