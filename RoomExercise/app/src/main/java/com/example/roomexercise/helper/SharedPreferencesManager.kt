package com.example.roomexercise.helper

import android.content.Context
import android.content.SharedPreferences
import java.security.Key


class SharedPreferencesManager {
    companion object {
        private const val APP_SETTINGS = "APP_SETTINGS"
        // properties
        private const val KEY_SEARCH = "keySearch"
        private const val CATEGORY_ID = "categoryID"


        private fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
        }

        fun getKeySearch(context: Context): String? {
            return getSharedPreferences(context).getString(KEY_SEARCH, null)
        }

        fun setKeySearch(context: Context, newValue: String?) {
            val editor = getSharedPreferences(context).edit()
            editor.putString(KEY_SEARCH, newValue).apply()
        }

        fun getCategoryID(context: Context): Int? {
            return getSharedPreferences(context).getInt(CATEGORY_ID, -1)
        }

        fun setCategoryID(context: Context, newValue: Int?) {
            val editor = getSharedPreferences(context).edit()
            newValue?.let { editor.putInt(CATEGORY_ID, newValue) }?.apply()
            editor.apply()
        }
    }
}