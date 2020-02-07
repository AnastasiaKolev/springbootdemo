package com.springcrud.springbootdemo.service;

import com.springcrud.springbootdemo.model.Note;
import com.springcrud.springbootdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note findById(Long id) {
        return noteRepository.findById( id ).orElse( null );
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note saveNote(Note note) {
        return noteRepository.save( note );
    }

    public void deleteById(Long id) {
        noteRepository.deleteById( id );

    }
}
