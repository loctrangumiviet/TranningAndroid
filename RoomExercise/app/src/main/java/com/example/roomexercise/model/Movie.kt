package com.example.roomexercise.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("categoryID"),
        childColumns = arrayOf("category_id")
    )]
)
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var movieName: String,
    @ColumnInfo(name = "category_id")
    var categoryID: Int
) {
}