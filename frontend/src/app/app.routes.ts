import { Routes } from '@angular/router';
import {Login} from './login/login';
import {Register} from './register/register';
import {Notes} from './notes/notes';
import {AjoutNote} from './ajout-note/ajout-note';

export const routes: Routes = [
  { path : 'login', component: Login},
  { path : 'register', component: Register},
  { path : 'notes', component: Notes},
  { path : 'ajoutNote', component: AjoutNote}
];
