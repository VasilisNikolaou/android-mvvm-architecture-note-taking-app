package com.example.notetakingapp.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notetakingapp.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDatabaseInstance;

    public static synchronized NoteDatabase getInstance(Context context) {
        if(noteDatabaseInstance == null) {
            noteDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return noteDatabaseInstance;
    }

    public abstract NoteDao noteDao();
}
