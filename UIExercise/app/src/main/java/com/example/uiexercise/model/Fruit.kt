package com.example.uiexercise.model

import java.io.Serializable
enum class Promotion{
    NONE,
    FREE_SHIP,
    SALE12
}

data class Fruit(
    var id: String,
    var title: String,
    var description: String,
    var linkImage: String,
    var price: Double,
    var discount: Double,
    var promotion: Promotion,
    var isFavorite: Boolean
) : Serializable {
}