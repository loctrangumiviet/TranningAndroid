package com.example.roomexercise.helper

import android.content.Context
import android.widget.Toast

class GlobalMethod {
    companion object {
        fun showToast(message: String, context: Context) {
            Toast.makeText(
                context,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}