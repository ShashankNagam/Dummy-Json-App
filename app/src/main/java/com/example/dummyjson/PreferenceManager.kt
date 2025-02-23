package com.example.dummyjson

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

object PreferenceManager {

    private const val PREF_NAME = "app_preferences"
    private const val KEY_THEME_MODE = "theme_mode"

    fun setThemeMode(context: Context, mode: Int) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt(KEY_THEME_MODE, mode).apply()
    }

    fun getThemeMode(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_THEME_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) // Default: Auto Mode
    }

}