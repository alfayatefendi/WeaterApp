package com.example.weaterapp.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weaterapp.R
import com.example.weaterapp.databinding.ItemRowWeatherBinding
import com.example.weaterapp.domain.model.weather.WeatherData
import com.example.weaterapp.utils.cleanZero
import com.example.weaterapp.utils.formattedDateNow

class ListWeatherAdapter:
    ListAdapter<WeatherData, ListWeatherAdapter.ListWeatherViewHolder>(DiffCallBack) {

    private lateinit var ctx: Context

    inner class ListWeatherViewHolder(
        private val binding: ItemRowWeatherBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(weatherData: WeatherData) {
            binding.apply {
                tvDay.text = weatherData.time.formattedDateNow(context = ctx)
                ivIconTemperature.setImageResource(weatherData.weatherType.iconRes)
                tvTemperature.text = ctx.getString(R.string.temp, weatherData.temperatureCelcius.toString().cleanZero())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListWeatherViewHolder {
        ctx = parent.context
        val binding = ItemRowWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListWeatherViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ListWeatherViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    private companion object DiffCallBack: DiffUtil.ItemCallback<WeatherData>(){

        override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
            return oldItem.time == newItem.time
        }
    }
}