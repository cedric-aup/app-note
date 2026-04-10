package com.gestion.note_app.models;

import jakarta.persistence.*;


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

    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}