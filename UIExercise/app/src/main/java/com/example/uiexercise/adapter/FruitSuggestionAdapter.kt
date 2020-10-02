package com.example.uiexercise.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uiexercise.R
import com.example.uiexercise.model.Fruit
import kotlinx.android.synthetic.main.fruit_suggestion_item.view.*

class FruitSuggestionAdapter: ListAdapter<Fruit,FruitSuggestionAdapter.FruitSuggestionVH>(FruitDiffCallBack()) {

    inner class FruitSuggestionVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(fruit: Fruit){
            with(itemView){
                fruitSuggestion_btnItem.text = fruit.title
                if(this@FruitSuggestionVH.adapterPosition == 0){
                    fruitSuggestion_btnItem.background.setTint(ContextCompat.getColor(itemView.context, R.color.Brown))
                }
                else{
                    fruitSuggestion_btnItem.background.setTint(ContextCompat.getColor(itemView.context, R.color.White))
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitSuggestionVH {
        return FruitSuggestionVH(LayoutInflater.from(parent.context).inflate(R.layout.fruit_suggestion_item,parent,false))
    }

    override fun onBindViewHolder(holder: FruitSuggestionVH, position: Int) {
        holder.bind(getItem(position))
    }
}