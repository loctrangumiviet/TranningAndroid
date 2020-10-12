package com.example.roomexercise.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.roomexercise.data.model.Movie

class MoviesCallBack : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}