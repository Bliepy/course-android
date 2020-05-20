package com.bliepy.level_7_task_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        start = findViewById(R.id.start)!!
        start.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, LocationFragment())
            ft.commit()
        }
    }

//
    private fun startQuestions() {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.content_frame, LocationFragment())
        ft.commit()
    }
//
////    private fun getResult() {
////        val ft = supportFragmentManager.beginTransaction()
////        ft.replace(R.id.content_frame, QuestionFragment())
////        ft.commit()
////    }
//
//
//    private fun locationNextQuestion(){
//
//        val ft = supportFragmentManager.beginTransaction()
////        ft.replace(R.id.content_frame, LocationFragment())
////        ft.commit()
////    }
//
//    private fun saveResults(model : QuestionModel, answer: Int, correct : Boolean){
//
//
//    }
//
//    private fun questionConfirm(model : QuestionModel){
//
//        val questionRadioGroup: RadioGroup = findViewById(R.id.questionRadioGroup)
//        val answerChecked : Int = questionRadioGroup.checkedRadioButtonId
//        val answerResult : Boolean = model.choices[answerChecked] == model.correctAnswer
//
//        saveResults(model,answerChecked,answerResult)
//
//        val ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.content_frame, QuestionFragment())
//        ft.commit()
//
//    }
//
//    fun load(model : QuestionModel){
//        val questionTitle: TextView = findViewById(R.id.questionTitle)
//        val questionRadioButton1: RadioButton = findViewById(R.id.questionRadioButton1)
//        val questionRadioButton2: RadioButton = findViewById(R.id.questionRadioButton2)
//        val questionRadioButton3: RadioButton = findViewById(R.id.questionRadioButton3)
//        val locationImage : ImageView = findViewById(R.id.locationImage)
//
//        questionTitle.text = model.question
//        questionRadioButton1.text = model.choices[0]
//        questionRadioButton2.text = model.choices[1]
//        questionRadioButton3.text = model.choices[2]
//        locationImage.setImageDrawable(getDrawable(model.clue))
//
//    }

}
