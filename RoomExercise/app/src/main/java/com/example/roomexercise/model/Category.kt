package com.example.roomexercise.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    var categoryID: Int = 0,
    var categoryName: String
) {
}