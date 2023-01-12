import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './home.component';
import {MatBadgeModule} from '@angular/material/badge';
import {FormsModule} from '@angular/forms';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import{MaterialModule} from '../../shared/material/material.module'
import{MatIconModule} from '@angular/material/icon'
@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    MatBadgeModule,
    FormsModule,
    MatMenuModule,
    MatButtonModule
  ]
})

export class HomeModule {
}
