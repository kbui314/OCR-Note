package com.example.todo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.todo.callbacks.NoteEventListener;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteHolder>{

    private Context context;
    private ArrayList<Note> notes;
    private NoteEventListener listener;


    public NotesAdapter(Context context, ArrayList<Note> notes){
        this.context = context;
        this.notes = notes;
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.notes_layout,viewGroup,false);
        return new NoteHolder(v);
    }

    /*
    This method will get you new unused view holders and have them filled with data that you want to
    display and as you scroll down, the view holders that went off the screen get replaced with new data.
     */
    @Override
    public void onBindViewHolder(NoteHolder noteHolder, int i) {
        final Note note = getNote(i);
        if(note != null){
            noteHolder.noteText.setText(note.getNoteText());
            noteHolder.noteDate.setText(NoteUtils.dateFromLong(note.getNoteDate()));

            //Init note click event
            noteHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNoteClick(note);
                }
            });

            //Init note long click
            noteHolder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View view) {
                    listener.onNoteLongClick(note);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private Note getNote(int position) {
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView noteText, noteDate;
        public NoteHolder(View itemView){
            super(itemView);
            noteDate=itemView.findViewById(R.id.note_date);
            noteText=itemView.findViewById(R.id.note_text);
        }
    }

    public void setListener(NoteEventListener listener){
        this.listener=listener;
    }
}
