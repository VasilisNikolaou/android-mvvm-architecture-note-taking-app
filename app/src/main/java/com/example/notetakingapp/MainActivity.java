    package com.example.notetakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.notetakingapp.adapter.NoteAdapter;
import com.example.notetakingapp.viewmodel.NoteViewModel;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Notes");

        final NoteAdapter noteAdapter = new NoteAdapter();
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(noteAdapter);

        this.noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        this.noteViewModel.getNotes().observe(this, noteAdapter::setNotes);
    }
}