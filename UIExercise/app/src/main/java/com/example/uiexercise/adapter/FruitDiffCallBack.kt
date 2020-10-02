package com.example.uiexercise.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.uiexercise.model.Fruit

class FruitDiffCallBack : DiffUtil.ItemCallback<Fruit>() {
    override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem == newItem
    }
}