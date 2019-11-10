package com.bliepy.rockpaperscissors.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.rockpaperscissors.R
import com.bliepy.rockpaperscissors.database.GameModel

class GameHistoryAdapter internal constructor(context: Context) : RecyclerView.Adapter<GameHistoryAdapter.GameViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gameCache = emptyList<GameModel>()

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textStatus: TextView = itemView.findViewById(R.id.text_status)
        val textTimestamp: TextView = itemView.findViewById(R.id.text_timestamp)
        val imageYou: ImageView = itemView.findViewById(R.id.image_computer)
        val imageComputer: ImageView = itemView.findViewById(R.id.image_you)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.content_game_history_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = gameCache[position]
        holder.textStatus.text = current.state
        holder.textTimestamp.text = current.timestamp

        val userImages = when (current.user) {
            1 -> R.drawable.paper
            2 -> R.drawable.rock
            else -> R.drawable.scissors
        }

        val computerImages = when (current.computer) {
            1 -> R.drawable.paper
            2 -> R.drawable.rock
            else -> R.drawable.scissors
        }
        holder.imageYou.setImageResource(userImages)
        holder.imageComputer.setImageResource(computerImages)
    }

    fun setGames(games: List<GameModel>) {
        this.gameCache = games
        notifyDataSetChanged()

    }

    override fun getItemCount() = gameCache.size
}