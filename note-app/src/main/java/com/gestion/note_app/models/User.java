package com.gestion.note_app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String mdp;

    public User (String email, String mdp) {
        this.email=email;
        this.mdp=mdp;
    }

    public User() {}

}