package com.example.roomexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexercise.R
import com.example.roomexercise.model.Movie
import kotlinx.android.synthetic.main.item_category.view.*

class MoviesAdapter: ListAdapter<Movie, MoviesAdapter.MoviesViewHolder>(MoviesCallBack()) {

    inner class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            itemView.tvCategoryItem.text = movie.movieName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}