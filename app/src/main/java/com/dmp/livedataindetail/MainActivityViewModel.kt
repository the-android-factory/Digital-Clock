package com.dmp.livedataindetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val secondsRightDisplayManager = DigitDisplayManager()
    val secondsLeftDisplayManager = DigitDisplayManager()

    fun startCounting() {
        viewModelScope.launch {
            var index = 0
            while (true) {
                secondsRightDisplayManager.onNewDigit(index % 10)
                secondsLeftDisplayManager.onNewDigit(index / 10)
                index++
                delay(1_000)
            }
        }
    }
}