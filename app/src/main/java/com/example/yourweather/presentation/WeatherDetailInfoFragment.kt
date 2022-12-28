package com.example.yourweather.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yourweather.databinding.WeatherDetatilInfoFragmentBinding

class WeatherDetailInfoFragment : Fragment() {


    private var _binding : WeatherDetatilInfoFragmentBinding? = null
    private val binding : WeatherDetatilInfoFragmentBinding
    get() = _binding ?: throw RuntimeException("FragmentDetailWeatherInfoBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = WeatherDetatilInfoFragmentBinding.inflate(inflater,container,false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object{
        fun newInstance():WeatherDetailInfoFragment{
            return WeatherDetailInfoFragment()
        }
    }
}