package com.example.yourweather.presentation

import android.os.Bundle
import android.util.Log
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
        Log.d("args",parseArgs())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs():String{
       return requireArguments().getString(DATE) ?: ""
    }

    companion object{
        private const val DATE = "date"
        fun newInstance(date : String):WeatherDetailInfoFragment{
            return WeatherDetailInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(DATE,date)
                }
            }
        }
    }
}