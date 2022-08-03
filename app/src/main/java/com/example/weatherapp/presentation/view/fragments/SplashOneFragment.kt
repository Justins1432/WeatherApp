package com.example.weatherapp.presentation.view.fragments

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
import com.example.weatherapp.databinding.FragmentSplashOneBinding

@Suppress("DEPRECATION")
class SplashOneFragment : Fragment() {
    private lateinit var binding: FragmentSplashOneBinding
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashOneBinding.inflate(inflater, container, false)
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
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashOneFragment_to_splashTwoFragment)
        }, 1500)
    }

}