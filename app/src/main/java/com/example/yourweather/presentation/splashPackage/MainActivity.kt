package com.example.yourweather.presentation.splashPackage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yourweather.R
import com.example.yourweather.databinding.ActivityMainBinding
import com.example.yourweather.presentation.splashPackage.SplashFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_splash_search, SplashFragment.newInstance())
            .commit()

    }
}

