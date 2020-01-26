package com.bliepy.gamebacklog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.gamebacklog.adapter.GameAdapter
import com.bliepy.gamebacklog.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var recycler: RecyclerView? = null
    private var gameAdapter: GameAdapter? = null
    private var gameViewModel: GameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recycler = findViewById(R.id.gameLogList)
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
              return  true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                gameViewModel?.removeGame(gameAdapter!!.get(viewHolder.adapterPosition))
                gameAdapter?.notifyDataSetChanged()
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler)
        fab.setOnClickListener {addGame()}
        load()
    }

    private fun load() {
        gameViewModel!!.getGameList().observe(this, Observer { data ->
            gameAdapter = GameAdapter(data)
            recycler?.layoutManager = LinearLayoutManager(this)
            recycler?.adapter = gameAdapter
            gameAdapter?.notifyDataSetChanged()
        })
    }

    fun addGame() {
        startActivity(Intent(this, AddActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_remove -> {
            gameViewModel?.removeAllGames()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
