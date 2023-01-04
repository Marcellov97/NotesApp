import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UtenteComponent} from "./utente/utente.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

//questa costante dice il componente da visualizzare quando si mette quel path nell address bar
const routes: Routes = [
  { path: 'utenti', component: UtenteComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule{}
