package com.example.notetakingapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notetakingapp.model.Note;
import com.example.notetakingapp.room.NoteDao;
import com.example.notetakingapp.room.NoteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> notes;
    private ExecutorService executorService;

    public NoteRepository(Application application) {
        this.noteDao = NoteDatabase.getInstance(application).noteDao();
        this.notes = noteDao.getAllNotes();
        this.executorService = Executors.newSingleThreadExecutor(runnable -> {
              Thread thread = new Thread(runnable);
              thread.setDaemon(true);

              return  thread;
        });
    }

    public void insertNote(Note note) {
        this.executorService.execute(() -> this.noteDao.insertNote(note));
    }

    public void deleteNote(Long id) {
        this.executorService.execute(() -> this.noteDao.deleteNote(id));
    }

    public void updateNote(Note note) {
        this.executorService.execute(() -> this.noteDao.updateNote(note));
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }
}
