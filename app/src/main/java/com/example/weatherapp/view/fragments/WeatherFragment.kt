package com.example.weatherapp.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.model.MyApplication
import com.example.weatherapp.model.MyApplication.Companion.apiWeather
import com.example.weatherapp.model.repository.ApiHelper
import com.example.weatherapp.utils.Status
import com.example.weatherapp.viewmodel.ViewModelFactory
import com.example.weatherapp.viewmodel.WeatherViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.text.DecimalFormat

@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private lateinit var root: View

    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        root = binding.root
        initComponents()
        initListener()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupObservers()

        MainScope().launch {
            val request = apiWeather.getCurrentWeather()

            /*Log.d("MyWeather", "${request.weather}")
            Log.d("MyWeather", "${request.main?.temp}")
            Log.d("MyWeather", "${request.main?.tempMax}")
            Log.d("MyWeather", "${request.main?.tempMin}")*/

        }

    }

    private fun initComponents() {
        (activity as AppCompatActivity).supportActionBar?.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    private fun initListener() {
        binding.imgSettings.setOnClickListener {
            findNavController().navigate(R.id.action_weatherFragment_to_settingsFragment)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(apiWeather))
        )[WeatherViewModel::class.java]
    }

    private fun setupObservers() {
        viewModel.getWeather().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        MainScope().launch {
                            val request = apiWeather.getCurrentWeather()
                            val temp = request.main?.temp
                            val city = request.name.toString()
                            val format: String = DecimalFormat("#0").format(temp)
                            View.VISIBLE
                            View.GONE
                            binding.city.text = city
                            binding.tempCity.text = format
                        }
                    }
                    Status.ERROR -> {
                        View.VISIBLE
                        View.GONE
                        Toast.makeText(root.context, it.message, Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> {
                        View.VISIBLE
                        View.GONE
                    }

                }
            }

        })

    }

}