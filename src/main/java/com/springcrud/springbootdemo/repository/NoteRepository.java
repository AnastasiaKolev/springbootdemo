package com.springcrud.springbootdemo.repository;

import com.springcrud.springbootdemo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
