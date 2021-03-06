package com.example.notetakingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEditNoteActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "com.example.notetakingapp.EXTRA_ID";
    public static final String EXTRA_TITLE = "com.example.notetakingapp.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.example.notetakingapp.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.example.notetakingapp.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        this.editTextTitle = findViewById(R.id.edit_text_title);
        this.editTextDescription = findViewById(R.id.edit_text_description);
        this.numberPickerPriority = findViewById(R.id.number_picker_priority);

        this.numberPickerPriority.setMinValue(1);
        this.numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_cancel);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            this.editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            this.editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            this.numberPickerPriority.setValue(Math.toIntExact(intent.getLongExtra(EXTRA_ID, 1L)));
        } else {
            setTitle("Add Note");
        }
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_TITLE, title);
        resultIntent.putExtra(EXTRA_DESCRIPTION, description);
        resultIntent.putExtra(EXTRA_PRIORITY, priority);

        Long id = getIntent().getLongExtra(EXTRA_ID, -1);

        if (id != -1L) {
            resultIntent.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, resultIntent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}