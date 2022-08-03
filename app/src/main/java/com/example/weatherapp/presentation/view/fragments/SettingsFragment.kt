package com.example.weatherapp.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var root: View

    private var flag: Boolean = true
    private lateinit var builder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private lateinit var window: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        root = binding.root
        initComponents()
        initListener()
        return root
    }

    private fun initComponents() {
        (activity as AppCompatActivity).supportActionBar?.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM

    }

    private fun initListener() {

        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnPlace.setOnClickListener {

            if (flag) {
                binding.btnPlace.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                builder = AlertDialog.Builder(root.context)
                alertDialog = builder.create()
                val layoutInflater = LayoutInflater.from(root.context)
                window = layoutInflater.inflate(R.layout.window_select_location, null)
                window.setOnClickListener {

                }
                alertDialog.cancel()
                alertDialog.setView(window)
                alertDialog.show()

            } else {
                binding.btnPlace.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)

            }
            flag = !flag



        }

    }

}