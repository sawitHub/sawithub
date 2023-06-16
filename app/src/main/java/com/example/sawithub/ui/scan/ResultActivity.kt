package com.example.sawithub.ui.scan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sawithub.R
import com.example.sawithub.databinding.ActivityResultBinding
import com.example.sawithub.databinding.ActivityScanBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val CAMERA_X_RESULT = 200
    }
}