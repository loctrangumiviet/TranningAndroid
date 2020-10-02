package com.example.uiexercise.adapter

import android.content.Context
import com.example.uiexercise.R
import com.example.uiexercise.model.Fruit
import com.example.uiexercise.model.Promotion
import java.util.*

class DataDummy {
    companion object {
        fun dummyData(context: Context): MutableList<Fruit> {
            return mutableListOf(
                Fruit(
                    UUID.randomUUID().toString(),
                    "Orange",
                    context.getString(R.string.fruit_description),
                    "https://thenationpress.net/en/imgs/2020/08/1597490497blobid0.jpg",
                    5.6,
                    6.7,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Cherry",
                    context.getString(R.string.fruit_description),
                    "https://quatangtraicay.com/wp-content/uploads/2019/05/cherry-uc.jpg",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Apple",
                    context.getString(R.string.fruit_description),
                    "https://sc02.alicdn.com/kf/UTB8L4HPotnJXKJkSaiyq6AhwXXam.jpg",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Banana",
                    context.getString(R.string.fruit_description),
                    "https://images.everydayhealth.com/images/diet-nutrition/how-many-calories-are-in-a-banana-1440x810.jpg?sfvrsn=be4504bc_0",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Watermelon",
                    context.getString(R.string.fruit_description),
                    "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/topic_centers/2018-12/10889-The_Watermelon_Diet_Fact_or_Fiction-_1296x728-header.jpg?w=1155&h=1528",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Avocado",
                    context.getString(R.string.fruit_description),
                    "https://post.greatist.com/wp-content/uploads/2020/08/10890-Dealing_with_an_Avocado_Allergy_732x549-thumbnail-732x549.jpg",
                    8.2,
                    9.9,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Kiwi",
                    context.getString(R.string.fruit_description),
                    "https://images.vov.vn/h500/uploaded/0jth2lsxjrk/2018_09_10/1_xcoverimage_1518699384_jpg_pagespeed_ic_zqztzLRkh__UVRA.jpg",
                    5.5,
                    6.7,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "strawberry",
                    context.getString(R.string.fruit_description),
                    "https://hips.hearstapps.com/clv.h-cdn.co/assets/15/22/1432664914-strawberry-facts1.jpg",
                    7.8,
                    8.7,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Orange",
                    context.getString(R.string.fruit_description),
                    "https://thenationpress.net/en/imgs/2020/08/1597490497blobid0.jpg",
                    5.6,
                    6.7,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Cherry",
                    context.getString(R.string.fruit_description),
                    "https://quatangtraicay.com/wp-content/uploads/2019/05/cherry-uc.jpg",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Apple",
                    context.getString(R.string.fruit_description),
                    "https://sc02.alicdn.com/kf/UTB8L4HPotnJXKJkSaiyq6AhwXXam.jpg",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Banana",
                    context.getString(R.string.fruit_description),
                    "https://images.everydayhealth.com/images/diet-nutrition/how-many-calories-are-in-a-banana-1440x810.jpg?sfvrsn=be4504bc_0",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Watermelon",
                    context.getString(R.string.fruit_description),
                    "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/topic_centers/2018-12/10889-The_Watermelon_Diet_Fact_or_Fiction-_1296x728-header.jpg?w=1155&h=1528",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Avocado",
                    context.getString(R.string.fruit_description),
                    "https://post.greatist.com/wp-content/uploads/2020/08/10890-Dealing_with_an_Avocado_Allergy_732x549-thumbnail-732x549.jpg",
                    8.2,
                    9.9,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Kiwi",
                    context.getString(R.string.fruit_description),
                    "https://images.vov.vn/h500/uploaded/0jth2lsxjrk/2018_09_10/1_xcoverimage_1518699384_jpg_pagespeed_ic_zqztzLRkh__UVRA.jpg",
                    5.5,
                    6.7,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "strawberry",
                    context.getString(R.string.fruit_description),
                    "https://hips.hearstapps.com/clv.h-cdn.co/assets/15/22/1432664914-strawberry-facts1.jpg",
                    7.8,
                    8.7,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Orange",
                    context.getString(R.string.fruit_description),
                    "https://thenationpress.net/en/imgs/2020/08/1597490497blobid0.jpg",
                    5.6,
                    6.7,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Cherry",
                    context.getString(R.string.fruit_description),
                    "https://quatangtraicay.com/wp-content/uploads/2019/05/cherry-uc.jpg",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Apple",
                    context.getString(R.string.fruit_description),
                    "https://sc02.alicdn.com/kf/UTB8L4HPotnJXKJkSaiyq6AhwXXam.jpg",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Banana",
                    context.getString(R.string.fruit_description),
                    "https://images.everydayhealth.com/images/diet-nutrition/how-many-calories-are-in-a-banana-1440x810.jpg?sfvrsn=be4504bc_0",
                    8.2,
                    9.9,
                    Promotion.SALE12,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Watermelon",
                    context.getString(R.string.fruit_description),
                    "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/topic_centers/2018-12/10889-The_Watermelon_Diet_Fact_or_Fiction-_1296x728-header.jpg?w=1155&h=1528",
                    8.2,
                    9.9,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Avocado",
                    context.getString(R.string.fruit_description),
                    "https://post.greatist.com/wp-content/uploads/2020/08/10890-Dealing_with_an_Avocado_Allergy_732x549-thumbnail-732x549.jpg",
                    8.2,
                    9.9,
                    Promotion.FREE_SHIP,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "Kiwi",
                    context.getString(R.string.fruit_description),
                    "https://images.vov.vn/h500/uploaded/0jth2lsxjrk/2018_09_10/1_xcoverimage_1518699384_jpg_pagespeed_ic_zqztzLRkh__UVRA.jpg",
                    5.5,
                    6.7,
                    Promotion.NONE,
                    false
                ),
                Fruit(
                    UUID.randomUUID().toString(),
                    "strawberry",
                    context.getString(R.string.fruit_description),
                    "https://hips.hearstapps.com/clv.h-cdn.co/assets/15/22/1432664914-strawberry-facts1.jpg",
                    7.8,
                    8.7,
                    Promotion.FREE_SHIP,
                    false
                ),
            )
        }
    }
}