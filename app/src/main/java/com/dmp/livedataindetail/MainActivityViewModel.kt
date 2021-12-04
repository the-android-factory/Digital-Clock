package com.dmp.livedataindetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    // region LiveData
    private val _segmentTopLiveData = MutableLiveData(R.color.unselected)
    val segmentTopLiveData: LiveData<Int> = _segmentTopLiveData

    private val _segmentTopLeftLiveData = MutableLiveData(R.color.unselected)
    val segmentTopLeftLiveData: LiveData<Int> = _segmentTopLeftLiveData

    private val _segmentTopRightLiveData = MutableLiveData(R.color.unselected)
    val segmentTopRightLiveData: LiveData<Int> = _segmentTopRightLiveData

    private val _segmentMiddleLiveData = MutableLiveData(R.color.unselected)
    val segmentMiddleLiveData: LiveData<Int> = _segmentMiddleLiveData

    private val _segmentBottomLeftLiveData = MutableLiveData(R.color.unselected)
    val segmentBottomLeftLiveData: LiveData<Int> = _segmentBottomLeftLiveData

    private val _segmentBottomRightLiveData = MutableLiveData(R.color.unselected)
    val segmentBottomRightLiveData: LiveData<Int> = _segmentBottomRightLiveData

    private val _segmentBottomLiveData = MutableLiveData(R.color.unselected)
    val segmentBottomLiveData: LiveData<Int> = _segmentBottomLiveData
    // endregion LiveData

    private val liveDataList = listOf(
        _segmentTopLiveData,
        _segmentTopLeftLiveData,
        _segmentTopRightLiveData,
        _segmentMiddleLiveData,
        _segmentBottomLeftLiveData,
        _segmentBottomRightLiveData,
        _segmentBottomLiveData
    )
    private val digitMap = mapOf(
        _segmentTopLiveData         to listOf(0, 2, 3, 5, 6, 7, 8, 9),
        _segmentTopLeftLiveData     to listOf(0, 4, 5, 6, 8, 9),
        _segmentTopRightLiveData    to listOf(0, 1, 2, 3, 4, 7, 8, 9),
        _segmentMiddleLiveData      to listOf(2, 3, 4, 5, 6, 8, 9),
        _segmentBottomLeftLiveData  to listOf(0, 2, 6, 8),
        _segmentBottomRightLiveData to listOf(0, 1, 3, 4, 5, 6, 7, 8, 9),
        _segmentBottomLiveData      to listOf(0, 2, 3, 5, 6, 8)
    )

    fun startCounting() {
        viewModelScope.launch {
            repeat(10) {
                onNewDigit(it)
                delay(2_000)
            }
        }
    }

    fun onNewDigit(digit: Int) {
        liveDataList.forEach { segmentLiveData ->
            val colorRes = if (digitMap[segmentLiveData]!!.contains(digit)) {
                R.color.selected
            } else {
                R.color.unselected
            }

            segmentLiveData.postValue(colorRes)
        }
    }
}