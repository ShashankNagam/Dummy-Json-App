package com.example.dummyjson

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dummyjson.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var setBinding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(setBinding.root)


        loadSavedTheme()

        setBinding.radioGroupTheme.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioLightMode -> {
                    ThemeManager.setTheme(this, AppCompatDelegate.MODE_NIGHT_NO)
                    setBinding.autoTxt.visibility = View.GONE
                }
                R.id.radioDarkMode -> {
                    ThemeManager.setTheme(this, AppCompatDelegate.MODE_NIGHT_YES)
                    setBinding.autoTxt.visibility = View.GONE
                }
                R.id.radioAutoMode -> {
                    ThemeManager.setTheme(this, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    setBinding.autoTxt.visibility = View.VISIBLE
                }
            }
        }


    }

    private fun loadSavedTheme() {
        val savedTheme = PreferenceManager.getThemeMode(this)

        when (savedTheme) {
            AppCompatDelegate.MODE_NIGHT_NO -> {
                setBinding.radioLightMode.isChecked = true
                setBinding.autoTxt.visibility = View.GONE
            }
            AppCompatDelegate.MODE_NIGHT_YES -> {
                setBinding.radioDarkMode.isChecked = true
                setBinding.autoTxt.visibility = View.GONE
            }
            else -> {
                setBinding.radioAutoMode.isChecked = true
                setBinding.autoTxt.visibility = View.VISIBLE // Show autoTxt when Auto Mode is selected
            }
        }
    }
}