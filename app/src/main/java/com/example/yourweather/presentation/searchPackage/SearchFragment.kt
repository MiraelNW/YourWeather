package com.example.yourweather.presentation.searchPackage

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.yourweather.R
import com.example.yourweather.utils.ViewModelFactory
import com.example.yourweather.utils.WeatherApp
import com.example.yourweather.databinding.SearchFragmentBinding
import com.example.yourweather.presentation.weatherPackage.WeatherActivity
import javax.inject.Inject

class SearchFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as WeatherApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: SearchViewModel

    private var _binding: SearchFragmentBinding? = null
    private val binding: SearchFragmentBinding
        get() = _binding ?: throw RuntimeException("SearchFragmentBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

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
            val color = ContextCompat.getColor(requireContext(), R.color.black)
            binding.cityName.backgroundTintList = ColorStateList.valueOf(color)
            viewModel =
                ViewModelProvider(requireActivity(), viewModelFactory)[SearchViewModel::class.java]
            observeViewModel(cityName)
        }
    }

    private fun observeViewModel(cityName: String) {
        val validCityName = viewModel.validateCityName(cityName)
        if (validCityName) {
            viewModel.startLoad(cityName)
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.progressBar.visibility = ProgressBar.VISIBLE
                } else {
                    binding.progressBar.visibility = ProgressBar.GONE

                    val intent = WeatherActivity.newIntent(requireActivity(), cityName)
                    startActivity(intent)
                    requireActivity().supportFragmentManager.popBackStack()

                }
            }
        } else {
            viewModel.error.observe(viewLifecycleOwner) {
                val color = ContextCompat.getColor(requireContext(), R.color.errorColor)
                binding.cityName.backgroundTintList = ColorStateList.valueOf(color)
                if (it) {
                    Toast.makeText(
                        requireContext(),
                        "Please, use only English letters",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }

        viewModel.apiError.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(
                    requireContext(),
                    "Is your internet work good?",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance(): Fragment {
            return SearchFragment()
        }
    }
}