import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Api } from '../core/services/api';
import { Note } from './Note';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-notes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './notes.html',
  styleUrls: ['./notes.scss'],
})
export class Notes implements OnInit {

  // 🔥 State réactif
  notes$ = new BehaviorSubject<Note[]>([]);

  constructor(private api: Api) {}

  ngOnInit(): void {
    this.loadNotes();
  }

  loadNotes(): void {
    const raw = localStorage.getItem('user');

    if (!raw) {
      console.error('No user in localStorage');
      return;
    }

    const user = JSON.parse(raw);

    console.log('Loading notes for user:', user.id);

    this.api.getNoteByUser(user.id).subscribe({
      next: (data: Note[]) => {
        console.log('NOTES RECEIVED:', data);

        // 🔥 update reactive state
        this.notes$.next([...data]);
      },
      error: (err) => {
        console.error('API ERROR:', err);
      }
    });
  }
}
