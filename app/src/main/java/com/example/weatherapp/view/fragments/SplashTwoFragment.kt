package com.example.weatherapp.view.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSplashTwoBinding

@Suppress("DEPRECATION")
class SplashTwoFragment : Fragment() {
    private lateinit var binding: FragmentSplashTwoBinding
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashTwoBinding.inflate(inflater, container, false)
        root = binding.root
        initComponents()
        splashScreen()
        return root
    }

    private fun initComponents() {
        (activity as AppCompatActivity).supportActionBar?.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity).supportActionBar?.setCustomView(R.layout.toolbar_title)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun splashScreen() {
        /**
         * Во время загрузки идет запрос на получение прогноза погоды
         */
        binding.progressBar.max = 2
        val currentProgress = 2
        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(2000).start()
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashTwoFragment_to_weatherFragment)
        }, 3000)
    }

}