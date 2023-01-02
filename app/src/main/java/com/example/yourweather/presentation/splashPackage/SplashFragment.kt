package com.example.yourweather.presentation.splashPackage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.yourweather.R
import com.example.yourweather.databinding.SplashFragmentBinding
import com.example.yourweather.presentation.searchPackage.SearchFragment
import com.example.yourweather.utils.WeatherApp
import com.mikhaellopez.rxanimation.*
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SplashFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as WeatherApp).component
    }

    private val disposable = CompositeDisposable()

    private var _binding: SplashFragmentBinding? = null
    private val binding: SplashFragmentBinding
        get() = _binding ?: throw RuntimeException("SplashFragmentBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SplashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val window = requireActivity().window
        window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.splashBarColor2)
        startAnimation()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        disposable.dispose()
        val window = requireActivity().window
        window.statusBarColor =  ContextCompat.getColor(requireActivity(), R.color.barColor)
    }


    private fun startAnimation() {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    binding.welcomeTextView.fadeOut(0L),
                    binding.imageViewEllipse.fadeOut(0L),
                    binding.imageViewBigCloud.fadeOut(0L),
                    binding.imageViewBigCloud2.fadeOut(0L),
                    binding.imageViewBigDarkCloud.fadeOut(0L),
                    binding.imageViewSmallCloud.fadeOut(0L),
                    binding.imageViewBigCloud.translationX(-100F, 0L),
                    binding.imageViewBigDarkCloud.translationX(200F, 0L),
                    binding.imageViewBigCloud2.translationX(200F, 0L),
                    binding.imageViewSmallCloud.translationX(-100f, 0L),
                ),

                RxAnimation.together(
                    binding.imageViewEllipse.fadeIn(1200),
                    binding.welcomeTextView.fadeIn(1200),
                    binding.imageViewBigCloud.fadeIn(500),
                    binding.imageViewBigCloud2.fadeIn(500),
                    binding.imageViewBigDarkCloud.fadeIn(500),
                    binding.imageViewSmallCloud.fadeIn(500),
                    binding.imageViewBigCloud.translationX(30F, 1000),
                    binding.imageViewBigDarkCloud.translationX(-30F, 1000),
                    binding.imageViewBigCloud2.translationX(-10F, 1000),
                    binding.imageViewSmallCloud.translationX(25F, 1000),
                )
            )
                .doOnTerminate() {
                    endSplashAnimation()
                }
                .subscribe()
        )
    }

    private fun endSplashAnimation() {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    binding.imageViewEllipse.fadeOut(500),
                    binding.welcomeTextView.fadeOut(500),
                ),

                RxAnimation.together(
                    binding.imageViewBigCloud.translationX(-500f, 500),
                    binding.imageViewSmallCloud.translationX(-500f, 500),
                    binding.imageViewBigCloud2.translationX(500f, 500),
                    binding.imageViewBigDarkCloud.translationX(500f, 500),
                ),

            )
                .doOnTerminate {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragment_container_splash_search,
                            SearchFragment.newInstance()
                        )
                        .commit()
                }
                .subscribe()

        )
    }

    companion object {
        fun newInstance(): Fragment {
            return SplashFragment()
        }
    }
}