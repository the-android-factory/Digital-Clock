package com.dmp.livedataindetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.dmp.livedataindetail.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindLiveData(viewModel.segmentTopLiveData, binding.segmentTop.root)
        bindLiveData(viewModel.segmentTopLeftLiveData, binding.segmentTopLeft.root)
        bindLiveData(viewModel.segmentTopRightLiveData, binding.segmentTopRight.root)
        bindLiveData(viewModel.segmentMiddleLiveData, binding.segmentMiddle.root)
        bindLiveData(viewModel.segmentBottomLeftLiveData, binding.segmentBottomLeft.root)
        bindLiveData(viewModel.segmentBottomRightLiveData, binding.segmentBottomRight.root)
        bindLiveData(viewModel.segmentBottomLiveData, binding.segmentBottom.root)

        viewModel.startCounting()
    }

    private fun bindLiveData(liveData: LiveData<Int>, materialCardView: MaterialCardView) {
        liveData.observe(this) { colorRes ->
            materialCardView.apply {
                val resolvedColor = ContextCompat.getColor(context, colorRes)
                setCardBackgroundColor(resolvedColor)
            }
        }
    }
}