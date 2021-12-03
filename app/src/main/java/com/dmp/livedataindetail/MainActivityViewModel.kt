package com.dmp.livedataindetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val _segmentStateLiveData = MutableLiveData(R.color.unselected)
    val segmentStateLiveData: LiveData<Int> = _segmentStateLiveData

    fun onButtonClicked() {
        val currentColor = _segmentStateLiveData.value
        val newColor = if (currentColor == R.color.unselected) {
            R.color.selected
        } else {
            R.color.unselected
        }
        _segmentStateLiveData.postValue(newColor)
    }
}