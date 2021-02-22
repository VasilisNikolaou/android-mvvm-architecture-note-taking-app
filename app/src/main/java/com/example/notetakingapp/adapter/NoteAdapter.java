package com.example.notetakingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notetakingapp.R;
import com.example.notetakingapp.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes;

    public NoteAdapter() {
        this.notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row_item, parent, false);

        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        Note currentNote = this.notes.get(position);

        holder.getTitleTxtView().setText(currentNote.getTitle());
        holder.getDescriptionTxtView().setText(currentNote.getDescription());
        holder.getPriorityTxtView().setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTxtView;
        private TextView descriptionTxtView;
        private TextView priorityTxtView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleTxtView = itemView.findViewById(R.id.text_view_title);
            this.descriptionTxtView = itemView.findViewById(R.id.text_view_description);
            this.priorityTxtView = itemView.findViewById(R.id.text_view_priority);
        }

        public TextView getTitleTxtView() {
            return titleTxtView;
        }

        public TextView getDescriptionTxtView() {
            return descriptionTxtView;
        }

        public TextView getPriorityTxtView() {
            return priorityTxtView;
        }
    }
}
