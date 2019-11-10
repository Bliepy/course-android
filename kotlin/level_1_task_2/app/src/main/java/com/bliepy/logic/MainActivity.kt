package com.bliepy.logic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.checkAnswer)
        button.setOnClickListener(View.OnClickListener {
             checkAnswer()
        })
    }

    /**
     * Check input value
     */

    private fun checkAnswer(){

        val case1 = findViewById<EditText>(R.id.case1).text
        val case2 = findViewById<EditText>(R.id.case2).text
        val case3 = findViewById<EditText>(R.id.case3).text
        val case4 = findViewById<EditText>(R.id.case4).text

        val solution = "$case1-$case2-$case3-$case4"

        if(solution == "T-F-F-F" || solution == "t-f-f-f" ) {
            Toast.makeText(this, getString(R.string.message_true), Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(this, getString(R.string.message_false), Toast.LENGTH_LONG).show()
        }
    }
}
