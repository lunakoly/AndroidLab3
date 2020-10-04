package com.example.androidlab3.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidlab3.R
import com.example.androidlab3.databinding.Task5View2Binding

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = Task5View2Binding.inflate(layoutInflater)

        binding.toFirst.setOnClickListener {
            view?.findNavController()?.navigate(R.id.second_to_first)
        }

        binding.toThird.setOnClickListener {
            view?.findNavController()?.navigate(R.id.second_to_third)
        }

        return binding.root
    }
}