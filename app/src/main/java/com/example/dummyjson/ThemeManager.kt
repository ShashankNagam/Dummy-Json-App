package com.example.dummyjson

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime

object ThemeManager {


    /*
    private var themeJob: Job? = null


    fun initializeTheme() {

        setAppThemeBasedOnTime()

        startThemeUpdate()
    }


    private fun startThemeUpdate() {

        themeJob?.cancel()

        themeJob = CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                delay(60000)
                setAppThemeBasedOnTime()
            }
        }
    }


    private fun setAppThemeBasedOnTime() {

        val darkModeStart = LocalTime.of(18, 0) // 6:00 PM
        val darkModeEnd = LocalTime.of(7, 0)   // 7:00 AM


        val currentTime = LocalTime.now()


        if (currentTime.isAfter(darkModeStart) || currentTime.isBefore(darkModeEnd)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun stopThemeUpdate() {
        themeJob?.cancel()
    } */

    fun initializeTheme(context: Context) {
        val themeMode = PreferenceManager.getThemeMode(context)
        applyTheme(themeMode)
    }

    fun setTheme(context: Context, mode: Int) {
        PreferenceManager.setThemeMode(context, mode)
        applyTheme(mode)
    }

    private fun applyTheme(mode: Int) {
        when (mode) {
            AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            AppCompatDelegate.MODE_NIGHT_NO -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else -> applyAutoTheme()
        }
    }

    private fun applyAutoTheme() {
        val darkModeStart = LocalTime.of(18, 0) // 6:00 PM
        val darkModeEnd = LocalTime.of(7, 0)   // 7:00 AM
        val currentTime = LocalTime.now()

        if (currentTime.isAfter(darkModeStart) || currentTime.isBefore(darkModeEnd)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}