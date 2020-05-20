package com.bliepy.level_7_task_2.model

data class QuestionModel(
    var question: String,
    var choices: Array<String>,
    var correctAnswer: String,
    var clue: Int
)