package com.example.todo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
This shows the current system date and time that the note was made and saved.
 */
public class NoteUtils {
    public static String dateFromLong(long time){
        DateFormat format = new SimpleDateFormat("EEE, dd MM yyyy 'at' hh:mm aaa", Locale.US);
        return format.format(new Date(time));
    }
}
