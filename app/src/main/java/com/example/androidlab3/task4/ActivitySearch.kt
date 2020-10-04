package com.example.androidlab3.task4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task4ActivitySearchBinding

class ActivitySearch : AppCompatActivity() {
    companion object {
        const val REQUEST = "REQUEST"
    }

    private var binding: Task4ActivitySearchBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivitySearch", "Created")

        val binding = Task4ActivitySearchBinding.inflate(layoutInflater)
        this.binding = binding

        setContentView(binding.root)
        updateResult(intent)

        binding.find.setOnClickListener {
            Log.d("ActivitySearch", "Starting")
            startActivity(Intent(this, ActivitySearch::class.java).apply {
                flags = FLAG_ACTIVITY_SINGLE_TOP
                putExtra(REQUEST, binding.request.text.toString())
            })
        }

        binding.act1.setOnClickListener {
            startActivity(Intent(this, Activity1::class.java))
        }
    }

    private fun updateResult(intent: Intent) {
        Log.d("ActivitySearch", "Updating")
        val request = intent.extras?.getString(REQUEST, null)

        request?.let {
            binding?.message?.text = getString(R.string.nothing_found_for, it)
            Log.d("ActivitySearch", "Updated")
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("ActivitySearch", "New Intent")

        intent?.let {
            updateResult(it)
        }
    }
}