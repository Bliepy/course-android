package com.bliepy.level_7_task_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bliepy.level_7_task_2.repository.QuestionRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    val questions =
        liveData(Dispatchers.IO) {
            val questions = QuestionRepository().getHvaQuest()
            emit(questions)
        }
}
