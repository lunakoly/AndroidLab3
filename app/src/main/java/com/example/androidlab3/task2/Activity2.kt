package com.example.androidlab3.task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task2Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Task2Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toFirst.setOnClickListener {
            finish()
        }

        binding.toThird.setOnClickListener {
            startActivityForResult(
                Intent(this, Activity3::class.java),
                LAUNCH_INNER_ACTIVITY
            )
        }

        binding.navView2.setNavigationItemSelectedListener {
            if (it.itemId == R.id.open_about) {
                startActivity(Intent(this, ActivityAbout::class.java))
                binding.drawer2.closeDrawer(GravityCompat.START, true)
            }

            true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LAUNCH_INNER_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                val passThrough = data?.getIntExtra(PASS_THROUGH, 0) ?: 0

                if (passThrough > 0) {
                    setResult(RESULT_OK, Intent().apply {
                        putExtra(PASS_THROUGH, passThrough - 1)
                    })
                    finish()
                }
            }
        }
    }
}