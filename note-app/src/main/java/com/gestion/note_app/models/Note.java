package com.gestion.note_app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Note (String title, String content, Date createdAt, Date updatedAt, User user){
        this.title=title;
        this.content=content;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.user=user;
    }

    public Note(){}

}