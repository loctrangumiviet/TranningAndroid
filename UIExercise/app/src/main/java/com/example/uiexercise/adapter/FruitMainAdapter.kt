package com.example.uiexercise.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uiexercise.R
import com.example.uiexercise.model.Fruit
import com.example.uiexercise.model.Promotion
import kotlinx.android.synthetic.main.fruit_item.view.*
import kotlinx.android.synthetic.main.fruit_suggestion_item.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class FruitMainAdapter(
    private val getWidthScreen: () -> Int,
    private val onClickListener: (Fruit) -> Unit
) : ListAdapter<Fruit, FruitMainAdapter.FruitViewHolder>(
    AsyncDifferConfig.Builder<Fruit>(FruitDiffCallBack())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    inner class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        fun bind(fruit: Fruit, position: Int) {
            with(itemView) {
                fruitItem_tvFruitTitle.text = fruit.title
                fruitItem_tvFruitDescription.text = fruit.description
                fruitItem_tvFruitPrice.text = "$${fruit.price}"
                fruitItem_tvDiscount.text = "$${fruit.discount}"
                fruitItem_btnPromotion.apply {
                    visibility = when (fruit.promotion) {
                        Promotion.FREE_SHIP -> {
                            text = itemView.context.getString(R.string.free_ship)
                            background.setTint(
                                ContextCompat.getColor(
                                    itemView.context,
                                    R.color.colorPrimary
                                )
                            )
                            View.VISIBLE
                        }
                        Promotion.SALE12 -> {
                            text = itemView.context.getString(R.string.sale_12)
                            background.setTint(
                                ContextCompat.getColor(
                                    itemView.context,
                                    R.color.orange
                                )
                            )
                            View.VISIBLE
                        }
                        else -> {
                            View.GONE
                        }
                    }
                }
                fruitItem_btnFruitCard.setOnClickListener { onClickListener(fruit) }
                fruitItem_btnFavorite.setOnClickListener {
                    fruit.isFavorite = if (fruit.isFavorite) {
                        fruitItem_btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        false
                    } else {
                        fruitItem_btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_pink_24)
                        true
                    }
                }
            }

            GlobalScope.launch(Dispatchers.IO) {
                val bitmap: Bitmap = Helper.getScaleBitmap(fruit.linkImage)!!
                withContext(Dispatchers.Main) {
                    Glide.with(itemView).load(bitmap).override(getWidthScreen() / 2)
                        .into(itemView.fruitItem_imgFruit)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}