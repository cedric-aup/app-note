package com.gestion.note_app.services;

import com.gestion.note_app.models.Note;
import com.gestion.note_app.models.User;
import com.gestion.note_app.repository.NoteRepository;
import com.gestion.note_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UserRepository userRepository){
        this.noteRepository=noteRepository;
        this.userRepository=userRepository;
    }

    public void createdNote(Note noteDto){
        User user = userRepository.findById(noteDto.getUser().getId())
                .orElseThrow(()-> new RuntimeException("Aucun User trouvé"));

        Note note = new Note ();
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setCreatedAt(new Date());
        note.setUser(noteDto.getUser());
        noteRepository.save(note);
    }

    public Note consultNote (Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElseThrow(() -> new RuntimeException("aucune note trouvée"));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public void updateNote(Note note, Long id){
        Note note1 = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));

        note1.setTitle(note.getTitle());
        note1.setContent(note.getContent());
        note1.setUpdatedAt(new Date());
        noteRepository.save(note1);
    }

    public List<Note> getNoteByUser(Long userId) {
        return noteRepository.findByUserId(userId);
    }
}
