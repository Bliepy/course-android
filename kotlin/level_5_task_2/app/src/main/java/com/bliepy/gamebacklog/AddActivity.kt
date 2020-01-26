package com.bliepy.gamebacklog

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bliepy.gamebacklog.model.GameEntity
import com.bliepy.gamebacklog.viewmodel.GameViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AddActivity : AppCompatActivity() {

    private var gameViewModel: GameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        saveAction()
    }

    fun saveAction (){
        fab.setOnClickListener {

            val gameTitle: EditText = findViewById(R.id.AddTitle)
            val gamePlatform: EditText = findViewById(R.id.AddPlatform)
            val gameDateDay : EditText= findViewById(R.id.AddDays)
            val gameDateMonth: EditText = findViewById(R.id.AddMonths)
            val gameDateYear: EditText = findViewById(R.id.AddYears)

            val title = gameTitle?.text.toString()
            val platform = gamePlatform?.text.toString()
            val days = gameDateDay.text.toString()
            val months = gameDateMonth.text.toString()
            val years = gameDateYear.text.toString()

            try {

                val date: LocalDate = LocalDate.parse("$years-$months-$days", DateTimeFormatter.ISO_DATE)
                gameViewModel?.createGame(
                    GameEntity(
                        title = title,
                        platform = platform,
                        date = date.toEpochDay()
                    )
                )
                startActivity(Intent(this, MainActivity::class.java))
            }catch (e: Exception){
                Snackbar.make(it, "Invalid date", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }
}
