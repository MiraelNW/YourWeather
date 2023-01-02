package com.example.yourweather.presentation.weatherPackage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.yourweather.R
import com.example.yourweather.utils.ViewModelFactory
import com.example.yourweather.utils.WeatherApp
import com.example.yourweather.databinding.MainWeatherFragmentBinding
import com.example.yourweather.domain.entity.DailyWeatherInfo
import com.example.yourweather.presentation.weatherPackage.WeatherAdapter.DailyWeatherAdapter
import com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailInfoFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as WeatherApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: WeatherViewModel

    private var _binding: MainWeatherFragmentBinding? = null
    private val binding: MainWeatherFragmentBinding
        get() = _binding ?: throw RuntimeException("MainWeatherFragmentBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainWeatherFragmentBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[WeatherViewModel::class.java]

        val adapter = DailyWeatherAdapter()
        binding.DailyWeatherRv.adapter = adapter

        viewModel.weatherList.invoke().observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.onWeekdayClickListener = object : DailyWeatherAdapter.OnWeekdayClickListener {
                override fun onWeekdayClick(dailyWeatherInfo: DailyWeatherInfo) {
                    loadWeatherDetailFragment(
                        dailyWeatherInfo.dailyTime,
                        dailyWeatherInfo.dayOfWeek
                    )
                }
            }
        }
        binding.cityName.text =
            String.format("Current weather in %s", parseArgs().replaceFirstChar { it.uppercase() })
        bindViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadWeatherDetailFragment(date: String, nameOfWeekDay: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_weather_container,
                WeatherDetailInfoFragment.newInstance(date, nameOfWeekDay)
            )
            .addToBackStack(null)
            .commit()
    }

    private fun bindViews() {
        lifecycleScope.launch {
            viewModel.hourlyWeather(getCurrDate()).observe(viewLifecycleOwner) {
                val weatherInfo = it
                binding.apparentTemperature.text =
                    String.format("%s°", it.apparentTemperature.roundToInt().toString())
                binding.humidity.text =
                    String.format("Humidity: %s%%", it.relativehumidity_2m.toString())
                binding.windSpeed.text =
                    String.format("Wind speed: \n %s km/h", it.windSpeed10m.toString())
                setImage(it.hourlyweathercode)
                binding.todayMaterialCard.setOnClickListener {
                    loadWeatherDetailFragment(
                        weatherInfo.hourlyTime.substring(0, 10),
                        weatherInfo.dayOfWeek
                    )
                }
            }
//
        }
    }

    private fun setImage(weatherCode: Int) {
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
            }

        }
    }

    private fun parseArgs(): String {
        return requireArguments().getString(CITY_NAME) ?: ""
    }

    private fun getCurrDate(): String {
        return ZonedDateTime.now().toString().substring(0, 14) + "00"
    }

    companion object {

        private const val ERROR = -1
        const val CITY_NAME = "cityName"

        fun newInstance(cityName: String): WeatherFragment {
            return WeatherFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_NAME, cityName)
                }
            }
        }
    }
}