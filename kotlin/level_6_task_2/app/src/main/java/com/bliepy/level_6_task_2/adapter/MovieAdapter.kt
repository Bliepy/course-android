package com.bliepy.level_6_task_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bliepy.level_6_task_2.R
import com.bliepy.level_6_task_2.model.MovieSearchEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_main.view.*

class MovieAdapter (private val listItems: List<MovieSearchEntity> = emptyList() , private val onItemClick: (MovieSearchEntity) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItems(listItems[position])
    }

    fun get(position : Int): MovieSearchEntity {
        return listItems[position]
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: MovieSearchEntity) {
            itemView.cardMovieId.text = movie.id

                Glide.with(itemView).load("https://image.tmdb.org/t/p/w185_and_h278_bestv2/".plus(movie.poster_path))
                    .apply(
                        RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE)
                        .error(R.color.colorAccent))
                    .fitCenter()
                    .into(itemView.cardMovieImage)
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listItems[adapterPosition])
            }
        }
    }
}