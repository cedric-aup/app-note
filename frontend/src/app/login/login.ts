import { Component } from '@angular/core';
import { Api } from '../core/services/api';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {

  email = '';
  mdp = '';
  constructor(private api: Api, private router: Router) {}


  login() {
    this.api.login({
      email: this.email,
      mdp: this.mdp
    }).subscribe({
      next: (user) => {

        // ✅ 1. stocker user connecté
        localStorage.setItem('user', JSON.stringify(user));

        // ✅ 2. redirection vers espace privé
        this.router.navigate(['/notes']);

      },
      error: (err) => {
        alert("Email ou mot de passe incorrect");
      }
    });
  }
}
