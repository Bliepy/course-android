package com.bliepy.gamebacklog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.gamebacklog.R
import com.bliepy.gamebacklog.model.GameEntity
import kotlinx.android.synthetic.main.item_game.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class GameAdapter (private val listItems: List<GameEntity>): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    var onItemClick: ((GameEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bindItems(listItems[position])
    }

    fun get(position : Int): GameEntity {
        return listItems[position]
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(game: GameEntity) {
            itemView.itemGameTitle.text = game.title
            itemView.itemGamePlatform.text = game.platform

            val localDate = LocalDate.ofEpochDay(game.date)
            val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd LLLL yyyy")

            itemView.itemGameDate.text =  localDate.format(formatter)
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listItems[adapterPosition])
            }
        }
    }
}