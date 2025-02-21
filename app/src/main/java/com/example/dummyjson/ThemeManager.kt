package com.example.dummyjson

import androidx.appcompat.app.AppCompatDelegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime

object ThemeManager {

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
    }

}