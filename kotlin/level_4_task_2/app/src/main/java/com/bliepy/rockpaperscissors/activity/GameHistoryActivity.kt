package com.bliepy.rockpaperscissors.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.rockpaperscissors.R
import com.bliepy.rockpaperscissors.database.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameHistoryActivity : AppCompatActivity() {


    private lateinit var gameRepository: GameRepository
    private lateinit var gameAdapter : GameHistoryAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_history)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        gameRepository = GameRepository(this)

        gameAdapter = GameHistoryAdapter(this)

        CoroutineScope(Dispatchers.Main).launch {
            gameAdapter.setGames(gameRepository.getAllGames())
        }

        recyclerView = findViewById(R.id.history_item_list)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = gameAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_delete -> {
            deleteAll()
            val intent = Intent(this, GameHistoryActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        return true
    }

    private fun deleteAll() {
        CoroutineScope(Dispatchers.Main).launch {
            gameRepository.deleteAll()
        }
    }
}
