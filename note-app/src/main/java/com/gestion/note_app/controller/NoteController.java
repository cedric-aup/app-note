package com.gestion.note_app.controller;

import com.gestion.note_app.models.Note;
import com.gestion.note_app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }

    @GetMapping("/getById/{id}")
    public Note getById(@PathVariable Long id){
        return noteService.consultNote(id);
    }

    @PostMapping("createNote")
    public void createNote(@RequestBody Note note){
        noteService.createdNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note){
        noteService.updateNote(note, id);
    }
}
