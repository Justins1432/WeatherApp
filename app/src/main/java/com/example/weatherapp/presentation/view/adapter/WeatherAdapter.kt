package com.example.weatherapp.presentation.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.data.ListForecast

class WeatherAdapter(val context: Context) :
    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    private lateinit var listForecast: List<ListForecast>

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateWeather: TextView = itemView.findViewById(R.id.dateWeather)
        val dayOfWeek: TextView = itemView.findViewById(R.id.dayOfWeek)
        val maxTemp: TextView = itemView.findViewById(R.id.maxTemp)
        val minTemp: TextView = itemView.findViewById(R.id.minTemp)
        val iconWeather: ImageView = itemView.findViewById(R.id.iconWeather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_item, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        /*val tempMax = forecastWeather[position].listForecast!![position].main?.tempMax.toString()
        val tempMin = forecastWeather[position].listForecast!![position].main?.tempMin.toString()
        val icon = forecastWeather[position].listForecast!![position].weather?.get(position)?.icon
        val weatherDate = forecastWeather[position].listForecast!![position].dtTxt

        var simpleWeatherDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val dateWeather: Date = simpleWeatherDate.parse(weatherDate!!)!!
        simpleWeatherDate = SimpleDateFormat("dd-MM-yyyy")
        val formatParsingDateWeather: String = simpleWeatherDate.format(dateWeather)

        holder.dateWeather.text = formatParsingDateWeather
        holder.maxTemp.text = tempMax
        holder.minTemp.text = tempMin*/

        val tempMax = listForecast[position].main?.tempMax.toString()
        val tempMin = listForecast[position].main?.tempMin.toString()
        val weatherDate = listForecast[position].dtTxt

        /*var simpleWeatherDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val dateWeather: Date = simpleWeatherDate.parse(weatherDate!!)!!
        simpleWeatherDate = SimpleDateFormat("dd-MM-yyyy")
        val formatParsingDateWeather: String = simpleWeatherDate.format(dateWeather)*/

        //holder.dateWeather.text = formatParsingDateWeather
        holder.maxTemp.text = tempMax
        holder.minTemp.text = tempMin

    }

    override fun getItemCount(): Int {
        return listForecast.size
    }
}