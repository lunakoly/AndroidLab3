package com.example.androidlab3.task5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task5ViewSearchBinding

class FragmentSearch : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Task5ViewSearchBinding.inflate(layoutInflater)

        binding.find.setOnClickListener {
            Log.d("ActivitySearch", "Starting")
            binding.message.text = getString(R.string.nothing_found_for, binding.request.text.toString())
            Log.d("ActivitySearch", "Updated")
        }

        binding.act1.setOnClickListener {
            view?.findNavController()?.navigate(R.id.search_to_first)
            view?.clearFocus()
        }

        return binding.root
    }
}