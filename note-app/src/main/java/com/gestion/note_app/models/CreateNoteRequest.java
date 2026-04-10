package com.gestion.note_app.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNoteRequest {
    private String title;
    private String content;
    private Long userId;

    public CreateNoteRequest(String title, String content, Long userId){
        this.title=title;
        this.content=content;
        this.userId=userId;
    }
}
