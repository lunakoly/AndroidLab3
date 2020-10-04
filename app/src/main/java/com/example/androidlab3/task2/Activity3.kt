package com.example.androidlab3.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task2Activity3Binding

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Task2Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirst.setOnClickListener {
            setResult(RESULT_OK, Intent().apply {
                putExtra(PASS_THROUGH, 1)
            })
            finish()
        }

        binding.toSecond.setOnClickListener {
            finish()
        }

        binding.navView3.setNavigationItemSelectedListener {
            if (it.itemId == R.id.open_about) {
                startActivity(Intent(this, ActivityAbout::class.java))
                binding.drawer3.closeDrawer(GravityCompat.START, true)
            }

            true
        }
    }
}