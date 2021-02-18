package com.example.notetakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.notetakingapp.viewmodel.NoteViewModel;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
       this.noteViewModel.getNotes().observe(this, notes -> {
            //Update the UI
           Toast.makeText(this, "onChanged", Toast.LENGTH_SHORT).show();
       });
    }
}