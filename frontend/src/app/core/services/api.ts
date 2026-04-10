import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Note} from '../../notes/Note';

@Injectable({
  providedIn: 'root',
})
export class Api {

  private baseUrl = 'http://localhost:8080';

  private constructor(private http: HttpClient) {}

  register(user: any){
    return this.http.post(`${this.baseUrl}/auth/register`, user)
  }

  login(user: any){
    return this.http.post(`${this.baseUrl}/auth/login`, user)
  }

  getNoteByUser(userId: number) {
    return this.http.get<Note[]>(`${this.baseUrl}/note/listNoteByUser/${userId}`);
  }

}
