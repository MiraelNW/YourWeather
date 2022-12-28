package com.example.yourweather.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.yourweather.R
import com.example.yourweather.databinding.MainWeatherFragmentBinding
import com.example.yourweather.presentation.WeatherAdapter.WeatherAdapter
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.time.ZonedDateTime

class MainWeatherFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    private var _binding : MainWeatherFragmentBinding? = null
    private val binding : MainWeatherFragmentBinding
    get() = _binding ?: throw RuntimeException("MainWeatherFragmentBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainWeatherFragmentBinding.inflate(inflater,container,false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = WeatherAdapter()
        binding.DailyWeatherRv.adapter = adapter

        viewModel.weatherList.invoke().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        bindViews()
        binding.todayMaterialCard.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_weather_container,WeatherDetailInfoFragment.newInstance())
                .commit()
        }






    }

    private fun bindViews(){
        lifecycleScope.launch {
            viewModel.dailyWeather(
                ZonedDateTime.now().toString().substring(0, 10)
            ).observe(viewLifecycleOwner){
                binding.apparentTemperature.text = String.format("%s°",it.apparentTemperatureMax?.toInt().toString())
                setImage(it.weatherCode ?: ERROR)
            }
            viewModel.hourlyWeather(
                ZonedDateTime.now().toString().substring(0, 14)+"00"
            ).observe(viewLifecycleOwner){
                binding.humidity.text = String.format("Humidity: %s%%", it.relativehumidity_2m.toString())
                binding.windSpeed.text = String.format("Wind speed: \n %s km/h", it.windSpeed10m.toString())
            }
        }
    }

    private fun setImage(weatherCode : Int){
        when (weatherCode) {
            0 -> Picasso.get().load(R.drawable.ic_clear_day).into(binding.weatherImage)
            1, 2 -> Picasso.get().load(R.drawable.ic_few_clouds).into(binding.weatherImage)
            3, 45, 48 -> Picasso.get().load(R.drawable.ic_mostly_cloudy).into(binding.weatherImage)
            51, 53, 55, 56, 57, 61, 63, 65, 66, 67, 80, 81, 82 -> Picasso.get()
                .load(R.drawable.ic_shower_rain)
                .into(binding.weatherImage)
            71, 73, 75, 77, 85, 86 -> Picasso.get().load(R.drawable.ic_snow_weather)
                .into(binding.weatherImage)
            else -> {
                Picasso.get().load(R.drawable.ic_unknown).into(binding.weatherImage)
                Log.d("Err", weatherCode.toString())
            }

        }
    }


    companion object{

        private const val ERROR = -1
        const val CITY_NAME = "cityName"

        fun newInstance(cityName :String): MainWeatherFragment {
            return MainWeatherFragment().apply {
                 arguments = Bundle().apply {
                    putString(CITY_NAME, cityName)
                }
            }
        }
    }
}