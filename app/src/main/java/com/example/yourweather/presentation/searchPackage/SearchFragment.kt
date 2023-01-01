package com.example.yourweather.presentation.searchPackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.yourweather.databinding.SearchFragmentBinding
import com.example.yourweather.presentation.splashPackage.WeatherActivity

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

    private fun observeViewModel(cityName: String) {
        viewModel.startLoad(cityName)
        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.progress = ProgressBar.VISIBLE
            } else {
                binding.progressBar.progress = ProgressBar.GONE
                val intent = WeatherActivity.newIntent(requireActivity(), cityName)
                startActivity(intent)
                requireActivity().supportFragmentManager.popBackStack()

            }
        }
        viewModel.error.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.progress = View.VISIBLE
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
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