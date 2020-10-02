package com.example.uiexercise.adapter

import android.R.attr
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.roundToInt


class Helper {
    companion object {
        fun getScaleBitmap(src: String): Bitmap? {
            var url: URL =  URL(src)
            val options: BitmapFactory.Options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeStream(url.openConnection().getInputStream(), null, options)
            options.inSampleSize = calculateInSampleSize(options, 256, 256)
            options.inJustDecodeBounds = false
            return BitmapFactory.decodeStream(url.openConnection().getInputStream(), null, options)!!
        }

        private fun calculateInSampleSize(
            options: BitmapFactory.Options,
            reqWidth: Int,
            reqHeight: Int
        ): Int {
            val width: Int = options.outWidth
            val height: Int = options.outHeight
            var inSampleSize = 1
            if (height > reqHeight || width > reqWidth) {
                val heightRatio: Int = (height.toFloat() / reqHeight.toFloat()).roundToInt()
                val widthRatio: Int = (width.toFloat() / reqWidth.toFloat()).roundToInt()

                inSampleSize = if (heightRatio < widthRatio) heightRatio else widthRatio
            }
            return inSampleSize
        }

        fun getWidthScreen(): Int {
            return Resources.getSystem().displayMetrics.widthPixels
        }
    }
}