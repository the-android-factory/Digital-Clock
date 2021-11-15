package com.dmp.livedataindetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.dmp.livedataindetail.databinding.ActivityMainBinding
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

        binding.button.setOnClickListener {
            viewModel.onButtonClicked()
        }

        viewModel.textViewInfoLiveData.observe(this) { info ->

            binding.textView.apply {
                text = info.text
                rotation = info.rotation.toFloat()
                setBackgroundColor(info.backgroundColor)
            }
        }
    }
}