package com.treinamento.view

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.treinamento.R
import com.treinamento.viewmodel.SplashScreenViewModel


class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by lazy {
        ViewModelProvider(this).get(
            SplashScreenViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash_screen)

        observes()
        fullScreen()
    }

    private fun observes() {
        viewModel.initSplashScreen()
        val observer = Observer<SplashScreenViewModel> {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        viewModel.liveData.observe(this, observer)
    }


    @Suppress("DEPRECATION")
    private fun fullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}
