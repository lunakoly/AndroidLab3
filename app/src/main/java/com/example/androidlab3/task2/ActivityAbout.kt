package com.example.androidlab3.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab3.databinding.Task2ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Task2ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}