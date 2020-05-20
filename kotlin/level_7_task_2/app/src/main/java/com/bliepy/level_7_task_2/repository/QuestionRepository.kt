package com.bliepy.level_7_task_2.repository

import com.bliepy.level_7_task_2.R
import com.bliepy.level_7_task_2.model.QuestionModel

class QuestionRepository {

    fun getHvaQuest(): List<QuestionModel> {
            return arrayListOf(
                QuestionModel(
                    "Who is the co-founder of Android?",
                    arrayOf("Andy Rubin", "Larry Page & Sergey Brin", "Sundar Pichai"),
                    "Andy Rubin",
                    R.drawable.nicolaes_tulphuis
                ),
                QuestionModel(
                    "In which language is Android written?",
                    arrayOf("Java/Kotlin", "Swift", "JavaScript"),
                    "Java/Kotlin",
                    R.drawable.fraijlemaborg
                ),
                QuestionModel(
                    "Which method gets called after onCreate in the Activity-lifecycle?",
                    arrayOf("onStart", "onCreateView", "onResume"),
                    "onStart",
                    R.drawable.leeuwenburg
                ),
                QuestionModel(
                    "In what year did google announce Material Design?",
                    arrayOf("2012", "2013", "2014"),
                    "2014",
                    R.drawable.muller_lulofshuis
                ),
                QuestionModel(
                    "What is the code name of version 1.6?",
                    arrayOf("Cupcake", "Donut", "Eclair"),
                    "Donut",
                    R.drawable.wibauthuis
                ),
                QuestionModel(
                    "Which version of Android did not run on phones?",
                    arrayOf("Android 1.0", "Android 2.0", "Android 3.0"),
                    "Android 3.0",
                    R.drawable.studio_hva
                ),
                QuestionModel(
                    "When did Google announced Android Wear?",
                    arrayOf("2012", "2013", "2014"),
                    "2014",
                    R.drawable.theo_thijssenhuis
                ),
                QuestionModel(
                    "Who built the first smartwatch?",
                    arrayOf("Sony, 2010", "Samsung, 2012", "LG, 2014"),
                    "Sony, 2010",
                    R.drawable.kohnstammhuis
                ),
                QuestionModel(
                    "For what for OS was Android originally created?",
                    arrayOf("Desktop computers", "Digital cameras", "Smartphones"),
                    "Digital cameras",
                    R.drawable.benno_premselahuis
                ),
                QuestionModel(
                    "Who is the CEO of Google?",
                    arrayOf("Andy Rubin", "Larry Page & Sergey Brin", "Sundar Pichai"),
                    "Sundar Pichai",
                    R.drawable.koetsier_montaignehuis
                )
            )
        }
    }

