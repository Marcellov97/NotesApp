import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UtenteComponent} from "./utente/utente.component";

//questa costante dice il componente da visualizzare quando si mette quel path nell address bar
const routes: Routes = [
  { path: 'utenti', component: UtenteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule{}
