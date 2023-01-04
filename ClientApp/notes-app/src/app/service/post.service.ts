import { Injectable } from '@angular/core';
import {POSTS} from "./DB-fake-posts";
import {Observable, of} from "rxjs";
import {Utente} from "../model/utente";
import {UTENTI} from "./DB-fake-utenti";
import {Post} from "../model/post";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor() { }

  getAllPosts(): Observable<Post[]>{
    const allPosts = of(POSTS);
    return allPosts;
  }
}
