import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {UtenteComponent} from "./utente/utente.component";
import { UtenteDetailComponent } from './utente-detail/utente-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    UtenteComponent,
    UtenteDetailComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
