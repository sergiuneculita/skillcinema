package com.example.skillcinema20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skillcinema20.databinding.ActivityMainBinding
import com.example.skillcinema20.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}