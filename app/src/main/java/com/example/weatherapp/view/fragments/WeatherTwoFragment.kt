package com.example.weatherapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.databinding.FragmentWeatherTwoBinding

class WeatherTwoFragment : Fragment() {
    private lateinit var binding: FragmentWeatherTwoBinding
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherTwoBinding.inflate(inflater, container, false)
        root = binding.root
        return root
    }
}