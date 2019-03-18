package com.example.todo.callbacks;

import com.example.todo.Note;

public interface NoteEventListener {
    /**
     * Call when note is clicked
     * @param note : Note item
     */
    void onNoteClick(Note note);

    /**
     * Call when note is long clicked
     * @param note
     */
    void onNoteLongClick(Note note);
}
