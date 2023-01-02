package com.example.yourweather.presentation.weatherDetailPackage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.yourweather.R
import com.example.yourweather.utils.ViewModelFactory
import com.example.yourweather.utils.WeatherApp
import com.example.yourweather.databinding.WeatherDetatilInfoFragmentBinding
import com.example.yourweather.presentation.weatherDetailPackage.WeatherDetailAdapter.HourlyWeatherAdapter
import com.squareup.picasso.Picasso
import java.time.ZonedDateTime
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherDetailInfoFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as WeatherApp).component
    }

    private var _binding: WeatherDetatilInfoFragmentBinding? = null
    private val binding: WeatherDetatilInfoFragmentBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailWeatherInfoBinding is null")


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: WeatherDetailInfoViewModel

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WeatherDetatilInfoFragmentBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[WeatherDetailInfoViewModel::class.java]
        observeViewModel()

        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.barColor2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.barColor)
        _binding = null
    }

    private fun observeViewModel() {
        val date = parseArgsDate()
        val adapter = HourlyWeatherAdapter()
        binding.hourlyWeatherRv.adapter = adapter

        viewModel.listOfHourlyWeather(getDateFrom(date), getDateTo(date))
            .observe(viewLifecycleOwner) {
                adapter.submitList(it)
            }
        viewModel.dailyWeather(followingDay()).observe(viewLifecycleOwner) {
            binding.sunrise.text =
                String.format(getString(R.string.sunrise), it.sunrise.toString().substring(11))
            binding.sunset.text =
                String.format(getString(R.string.sunset), it.sunset.toString().substring(11))
        }

        viewModel.hourlyWeather(getDateFrom(date))
            .observe(viewLifecycleOwner) {
                val weatherInfo = it
                with(binding) {
                    weekDay.text = parseArgsWeekday()
                    setImage(weatherInfo.hourlyweathercode)
                    humidity.text =
                        String.format(
                            getString(R.string.humidity),
                            it.relativehumidity_2m.toString()
                        )
                    windSpeed.text =
                        String.format(
                            getString(R.string.windSpeed),
                            it.windSpeed10m.roundToInt().toString()
                        )
                    shortwaveRadiation.text =
                        String.format(
                            getString(R.string.waveRadiation),
                            it.shortwaveRadiation.toString()
                        )
                    if (it.visibility >= 15000) {
                        visibility.text = String.format(getString(R.string.greatVisility))
                    } else if (it.visibility >= 10000 && it.visibility < 15000) {
                        visibility.text = String.format(getString(R.string.goodVisibility))
                    } else if (it.visibility >= 5000 && it.visibility < 10000) {
                        visibility.text = String.format(getString(R.string.normalVisibility))
                    } else if (it.visibility >= 0 && it.visibility < 5000) {
                        visibility.text = String.format(getString(R.string.badVisibility))
                    }
                }
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

    private fun parseArgsDate(): String {
        return requireArguments().getString(DATE) ?: ""
    }

    private fun parseArgsWeekday(): String {
        return requireArguments().getString(NAME_OF_WEEKDAY) ?: ""
    }

    private fun getDateFrom(date: String): String {
        return date + "T01:00"
    }

    private fun getDateTo(date: String): String {
        return date + "T23:00"
    }

    private fun followingDay(): String {
        return ZonedDateTime.now().plusDays(1).toString().substring(0, 10)
    }

    companion object {
        private const val DATE = "date"
        private const val NAME_OF_WEEKDAY = "nameOfWeekDay"
        fun newInstance(date: String, nameOfWeekDay: String): WeatherDetailInfoFragment {
            return WeatherDetailInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(DATE, date)
                    putString(NAME_OF_WEEKDAY, nameOfWeekDay)
                }
            }
        }
    }
}