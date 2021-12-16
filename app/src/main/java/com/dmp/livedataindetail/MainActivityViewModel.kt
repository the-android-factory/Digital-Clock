package com.dmp.livedataindetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val hourRightDisplayManager = DigitDisplayManager()
    val hourLeftDisplayManager = DigitDisplayManager()

    val secondsRightDisplayManager = DigitDisplayManager()
    val secondsLeftDisplayManager = DigitDisplayManager()

    fun startCounting() {
        viewModelScope.launch {
            var index = 0
            while (true) {
                val hours = index / 60
                val seconds = index % 60

                hourRightDisplayManager.onNewDigit(hours % 10)
                hourLeftDisplayManager.onNewDigit(hours / 10)

                secondsRightDisplayManager.onNewDigit(seconds % 10)
                secondsLeftDisplayManager.onNewDigit(seconds / 10)
                index++
                delay(250)
            }
        }
    }
}