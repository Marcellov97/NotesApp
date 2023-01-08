import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Segnalazione} from "../model/segnalazione";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SegnalazioneService {

  private URL = 'http://localhost:8080/segnalazione'

  constructor(private http: HttpClient) { }

  //************************************************************
  //METODI HTTP SEGNALAZIONE
  //TODO tutti i metodi sono da testare

  setSegnalazione(segnalazione : Segnalazione): Observable<Segnalazione>{
    return this.http.post<Segnalazione>(this.URL, segnalazione)
  }
}
