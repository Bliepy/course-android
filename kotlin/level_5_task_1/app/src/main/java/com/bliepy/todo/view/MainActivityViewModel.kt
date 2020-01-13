package com.bliepy.todo.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bliepy.todo.database.NoteRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)
    val note = noteRepository.getNotepad()

}
