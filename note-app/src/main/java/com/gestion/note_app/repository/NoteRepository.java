package com.gestion.note_app.repository;

import com.gestion.note_app.models.Note;
import com.gestion.note_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
}
