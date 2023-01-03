import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //qua definisco le variabili che poi posso usare all'interno del file HTML

  title = 'Schermata iniziale Notes App';

  body = 'Questo è il body, ossia dove si scrive la maggior parte della roba.';
}
