package com.example.dummyjson

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dummyjson.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var setBinding : ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(setBinding.root)

    }
}