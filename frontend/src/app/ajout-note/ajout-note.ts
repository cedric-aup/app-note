import { Component } from '@angular/core';
import {Api} from '../core/services/api';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-ajout-note',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './ajout-note.html',
  styleUrl: './ajout-note.scss',
})
export class AjoutNote {

  constructor(private api: Api, private router: Router) {}

  title = '';
  content = '';

  createNote() {
    const user = JSON.parse(localStorage.getItem('user') || '{}');

    const payload = {
      title: this.title,
      content: this.content,
      userId: user.id
    };
    console.log(payload);

    this.api.createNote(payload).subscribe({
      next: (note) => {

        console.log('Note créée', note);

        this.router.navigate(['/notes']);
      },
      error: (err) => {
        alert("Erreur lors de la création de la note");
      }
    });
  }
}
