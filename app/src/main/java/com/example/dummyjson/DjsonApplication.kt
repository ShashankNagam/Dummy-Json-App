package com.example.dummyjson

import android.app.Application

class DjsonApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        ThemeManager.initializeTheme(this)
    }

    override fun onTerminate() {
        super.onTerminate()
//        ThemeManager.stopThemeUpdate()
    }

}