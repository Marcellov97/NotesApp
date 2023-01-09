import {NgModule} from "@angular/core";
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import{LoginComponent} from "./components/login/login.component"
import {HomeComponent} from './components/home/home.component';

//questa costante dice il componente da visualizzare quando si mette quel path nell address bar
const routes: Routes = [
  {path: '' ,
  component: HomeComponent,
  },

  {path : 'login',component: LoginComponent}
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule{

}
