package com.dmp.livedataindetail

import androidx.annotation.ColorRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DigitDisplayManager {

    private val _digitDisplayLiveData = MutableLiveData<Map<Int, Int>>()
    val digitDisplayLiveData: LiveData<Map<Int, Int>> = _digitDisplayLiveData

    private val segmentIdList = listOf(
        R.id.segmentTop,
        R.id.segmentTopLeft,
        R.id.segmentTopRight,
        R.id.segmentMiddle,
        R.id.segmentBottomLeft,
        R.id.segmentBottomRight,
        R.id.segmentBottom
    )

    private val digitMap = mapOf(
        R.id.segmentTop         to listOf(0, 2, 3, 5, 6, 7, 8, 9),
        R.id.segmentTopLeft     to listOf(0, 4, 5, 6, 8, 9),
        R.id.segmentTopRight    to listOf(0, 1, 2, 3, 4, 7, 8, 9),
        R.id.segmentMiddle      to listOf(2, 3, 4, 5, 6, 8, 9),
        R.id.segmentBottomLeft  to listOf(0, 2, 6, 8),
        R.id.segmentBottomRight to listOf(0, 1, 3, 4, 5, 6, 7, 8, 9),
        R.id.segmentBottom      to listOf(0, 2, 3, 5, 6, 8)
    )

    fun onNewDigit(digit: Int) {
        val state = HashMap<Int, Int>()
        segmentIdList.forEach { id ->
            val colorRes = if (digitMap[id]!!.contains(digit)) {
                R.color.selected
            } else {
                R.color.unselected
            }

            state[id] = colorRes
        }
        _digitDisplayLiveData.postValue(state)
    }
}