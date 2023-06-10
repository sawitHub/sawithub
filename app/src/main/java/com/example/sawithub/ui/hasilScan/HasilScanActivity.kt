package com.example.sawithub.ui.hasilScan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sawithub.databinding.ActivityHasilScanBinding
import com.example.sawithub.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HasilScanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilScanBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}