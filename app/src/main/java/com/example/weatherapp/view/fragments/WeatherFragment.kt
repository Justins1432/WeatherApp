package com.example.weatherapp.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.MyApplication
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        root = binding.root
        initComponents()
        goToSettings()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainScope().launch {
            val a = MyApplication.apiWeather.getWeatherAsync()
            Log.d("MyTest", "${a.await().coord}")
            Log.d("MyTest", "${a.await().weather}git ")
        }
    }

    private fun initComponents() {
        (activity as AppCompatActivity).supportActionBar?.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun goToSettings() {
        binding.imgSettings.setOnClickListener {
            findNavController().navigate(R.id.action_weatherFragment_to_settingsFragment)
        }
    }
}
