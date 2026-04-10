import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Api } from '../core/services/api';
import { Note } from './Note';
import { BehaviorSubject } from 'rxjs';
import {RouterLink, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-notes',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './notes.html',
  styleUrls: ['./notes.scss'],
})
export class Notes implements OnInit {

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

        this.notes$.next([...data]);
      },
      error: (err) => {
        console.error('API ERROR:', err);
      }
    });
  }
}
