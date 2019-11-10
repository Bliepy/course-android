package com.bliepy.rockpaperscissors.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bliepy.rockpaperscissors.R
import com.bliepy.rockpaperscissors.database.GameModel
import com.bliepy.rockpaperscissors.database.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*



class GameActivity : AppCompatActivity() {

    var PAPER: Int = 1
    var ROCK: Int = 2
    var SCISSOR: Int = 3

    var win :  Int = 0
    var lose : Int = 0
    var draw : Int = 0

    private lateinit var gameRepository: GameRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        gameRepository = GameRepository(this)


        val imagePaperAction = findViewById<ImageButton>(R.id.button_paper)
        imagePaperAction?.setOnClickListener {
            Toast.makeText(this, playGame(PAPER), Toast.LENGTH_LONG).show()
        }

        val imageRockAction = findViewById<ImageButton>(R.id.button_rock)
        imageRockAction?.setOnClickListener {
            Toast.makeText(this, playGame(ROCK), Toast.LENGTH_LONG).show()
        }

        val imageScissorsAction = findViewById<ImageButton>(R.id.button_scissor)
        imageScissorsAction?.setOnClickListener {
            Toast.makeText(this, playGame(SCISSOR), Toast.LENGTH_LONG).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_history -> {
            val intent = Intent(this, GameHistoryActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }




    private fun playGame(userState: Int): String {
        val computerState: Int = Random().nextInt(3)+ 1

        var result: String = resultGame(userState, computerState)
        saveGame(userState, computerState, result)
        return result
    }

    private fun resultGame(user: Int, computer: Int): String {

        val userImages = when (user) {
            1 -> R.drawable.paper
            2 -> R.drawable.rock
            else -> R.drawable.scissors
        }

        val computerImages = when (computer) {
            1 -> R.drawable.paper
            2 -> R.drawable.rock
            else -> R.drawable.scissors
        }




        val imageComputer :ImageView = findViewById(R.id.image_computer)
        imageComputer.setImageResource(computerImages)

        val imageYou :ImageView = findViewById(R.id.image_you)
        imageYou.setImageResource(userImages)

        val textStates : TextView = findViewById(R.id.text_stats)
        textStates.text = "Win: $win Draw: $draw Lose: $lose"


        if (user == computer) { draw += 1; return resources.getString(R.string.game_draw)}
        if (user == 1 && computer == 2) { win += 1; return resources.getString(R.string.game_you_win)}

        if (user == 1 && computer == 3){ lose += 1;  return resources.getString(R.string.game_computer_wins)}
        if (user == 2 && computer == 1) { lose += 1; return resources.getString(R.string.game_computer_wins)}
        if (user == 2 && computer == 3) { win += 1; return resources.getString(R.string.game_you_win)}
        if (user == 3 && computer == 1) { win += 1; return resources.getString(R.string.game_you_win)}
        if (user == 3 && computer == 2) { lose += 1; return resources.getString(R.string.game_computer_wins)}




        return "error"

    }

    private fun saveGame(userState: Int, computer: Int, result: String) {
        CoroutineScope(Dispatchers.Main).launch {


            gameRepository.saveGame(
                GameModel(
                    null,
                    computer,
                    userState,
                    result,
                    LocalDateTime.now().toString()
                )
            )
        }
    }
}
