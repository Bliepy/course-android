package com.bliepy.todo.database


import android.content.Context
import androidx.lifecycle.LiveData
import com.bliepy.todo.model.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NoteRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNote()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}