package com.example.notetakingapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notetakingapp.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNote(Note note);

    @Query("DELETE FROM Note WHERE id = :id")
    void deleteNote(Long id);

    @Update
    void updateNote(Note note);
}
