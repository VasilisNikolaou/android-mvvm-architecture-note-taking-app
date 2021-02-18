package com.example.notetakingapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notetakingapp.model.Note;
import com.example.notetakingapp.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        this.noteRepository = new NoteRepository(application);
        this.notes = this.noteRepository.getNotes();
    }

    public void insertNote(Note note) {
        this.noteRepository.insertNote(note);
    }

    public void deleteNote(Long id) {
        this.noteRepository.deleteNote(id);
    }

    public void updateNote(Note note) {
        this.noteRepository.updateNote(note);
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }
}
