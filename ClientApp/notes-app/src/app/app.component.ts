import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //qua definisco le variabili che poi posso usare all'interno del file HTML

  title = 'Notes App';

  body = 'Di seguito ci sono i link di maggiore utilità';
}
