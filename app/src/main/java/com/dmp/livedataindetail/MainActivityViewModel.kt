package com.dmp.livedataindetail

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {

    private val _textViewInfoLiveData = MutableLiveData<TextViewInfo>()
    val textViewInfoLiveData: LiveData<TextViewInfo> = _textViewInfoLiveData

    data class TextViewInfo(
        val text: String,
        val rotation: Int,
        val backgroundColor: Int
    )

    fun onButtonClicked() {
        val info = getRandomInfo()
        _textViewInfoLiveData.postValue(info)
    }

    private fun getRandomInfo(): TextViewInfo {
        return TextViewInfo(
            text = Random().nextInt(100).toString(),
            rotation = Random().nextInt(360),
            backgroundColor = getRandomColor()
        )
    }

    private fun getRandomColor(): Int {
        return Color.rgb(
            Random().nextInt(255),
            Random().nextInt(255),
            Random().nextInt(255)
        )
    }
}