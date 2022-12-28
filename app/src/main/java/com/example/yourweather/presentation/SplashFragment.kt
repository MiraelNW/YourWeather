package com.example.yourweather.presentation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yourweather.R
import com.example.yourweather.databinding.SplashFragmentBinding
import com.mikhaellopez.rxanimation.*
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SplashFragment : Fragment() {


    private val disposable = CompositeDisposable()

    private var _binding : SplashFragmentBinding? = null
    private val binding : SplashFragmentBinding
        get() = _binding ?: throw RuntimeException("SplashFragmentBinding is null")


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
        startAnimation()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //component
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        disposable.dispose()
    }


    private fun startAnimation() {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    binding.imageViewBottomDrawable.translationY(500f),
                    binding.imageViewEllipse.fadeOut(0L),
                    binding.imageViewBottomDrawable.fadeOut(0L),
                    binding.imageViewBigCloud.translationX(-500F, 0L),
                    binding.imageViewSmallCloud.translationX(500f, 0L),
                    binding.imageViewBottomDrawableShadow.translationY(500f),
                    binding.imageViewMainCloud.fadeOut(0L),
                    binding.imageViewBottomDrawableShadow.fadeOut(0L)
                ),

                RxAnimation.together(
                    binding.imageViewBottomDrawable.fadeIn(1000L),
                    binding.imageViewBottomDrawable.translationY(-1f),
                    binding.imageViewBottomDrawableShadow.fadeIn(1250L),
                    binding.imageViewBottomDrawableShadow.translationY(-1f)
                ),

                RxAnimation.together(
                    binding.imageViewEllipse.fadeIn(1000L),
                    binding.imageViewEllipse.translationY(-50F, 1000L)
                ),

                RxAnimation.together(
                    binding.imageViewBigCloud.translationX(-15f, 1000L),
                    binding.imageViewSmallCloud.translationX(25f, 1000L)
                ),

                binding.imageViewMainCloud.fadeIn(500L),

            )
                .doOnTerminate(){
                    endSplashAnimation()
                }
                .subscribe()
        )
    }

    private fun endSplashAnimation() {
        disposable.add(
            RxAnimation.sequentially(
                RxAnimation.together(
                    binding.imageViewBottomDrawable.fadeOut(300L),
                    binding.imageViewBottomDrawable.translationY(100f),
                    binding.imageViewBottomDrawableShadow.fadeOut(300L),
                    binding.imageViewBottomDrawableShadow.translationY(100f)
                ),

                RxAnimation.together(
                    binding.imageViewEllipse.fadeOut(300L),
                    binding.imageViewEllipse.translationY(500F, 300L)
                ),

                RxAnimation.together(
                    binding.imageViewBigCloud.translationX(500f, 300L),
                    binding.imageViewSmallCloud.translationX(-500f, 300L)
                ),

                binding.imageViewMainCloud.fadeOut(300L),

                binding.rootView.backgroundColor(
                    Color.parseColor("#5D50FE"),
                    Color.parseColor("#FFFFFF"),
                    duration = 750L
                )
            )
                .doOnTerminate {
                   requireActivity().supportFragmentManager.beginTransaction()
                       .replace(R.id.fragment_container_splash_search,SearchFragment.newInstance())
                       .commit()
                }
                .subscribe()

        )
    }

    companion object{
        fun newInstance():Fragment{
            return SplashFragment()
        }
    }
}