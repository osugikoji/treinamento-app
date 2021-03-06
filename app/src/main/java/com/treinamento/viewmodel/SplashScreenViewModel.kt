package com.treinamento.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel: ViewModel() {
    var liveData: MutableLiveData<SplashScreenViewModel> = MutableLiveData()

    fun initSplashScreen() {
        viewModelScope.launch {
            delay(3000)
            updateLiveData()
        }
    }

    private fun updateLiveData() {
        val splashModel = SplashScreenViewModel()
        liveData.value = splashModel
    }
}