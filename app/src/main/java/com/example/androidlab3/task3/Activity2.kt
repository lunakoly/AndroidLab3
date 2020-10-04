package com.example.androidlab3.task3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task2Activity2Binding
import com.example.androidlab3.task2.ActivityAbout

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Task2Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirst.setOnClickListener {
            finish()
        }

        binding.toThird.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }

        binding.navView2.setNavigationItemSelectedListener {
            if (it.itemId == R.id.open_about) {
                startActivity(Intent(this, ActivityAbout::class.java))
                binding.drawer2.closeDrawer(GravityCompat.START, true)
            }

            true
        }
    }
}