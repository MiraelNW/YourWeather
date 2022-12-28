package com.example.yourweather.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.yourweather.databinding.SearchFragmentBinding
import com.example.yourweather.databinding.SplashFragmentBinding
import com.example.yourweather.presentation.WeatherAdapter.WeatherAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[SearchViewModel::class.java]
    }

    private var _binding: SearchFragmentBinding? = null
    private val binding: SearchFragmentBinding
        get() = _binding ?: throw RuntimeException("SearchFragmentBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showWeather.setOnClickListener {
            val cityName = binding.cityName.text.toString().trim()
            observeViewModel(cityName)
        }
    }

    private fun observeViewModel(cityName:String){
        viewModel.startLoad(cityName)
        viewModel.loading.observe(viewLifecycleOwner){
            if(it) {
                binding.progressBar.progress = View.VISIBLE
            }else{
                binding.progressBar.progress = View.GONE
                val intent = WeatherActivity.newIntent(requireActivity(), cityName)
                startActivity(intent)
                requireActivity().supportFragmentManager.popBackStack()

            }
        }
    }


    companion object {
        fun newInstance(): Fragment {
            return SearchFragment()
        }
    }
}