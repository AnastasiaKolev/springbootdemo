package com.springcrud.springbootdemo.controller;

import com.springcrud.springbootdemo.model.Note;
import com.springcrud.springbootdemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String findAll(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute( "notes", notes );
        return "note-list";
    }

    @GetMapping("/note-create")
    public String createNoteForm(Note note) {
        return "note-create";
    }

    @PostMapping("/note-create")
    public String createNote(Note note) {
        noteService.saveNote( note );
        return "redirect:/notes";
    }

    @GetMapping("note-delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteById( id );
        return "redirect:/notes";
    }

    @GetMapping("/note-update/{id}")
    public String updateNoteForm(@PathVariable("id") Long id, Model model) {
        Note note = noteService.findById( id );
        model.addAttribute( "note", note );
        return "/note-update";
    }

    @PostMapping("/note-update")
    public String updateNote(Note note) {
        noteService.saveNote( note );
        return "redirect:/notes";
    }
}
