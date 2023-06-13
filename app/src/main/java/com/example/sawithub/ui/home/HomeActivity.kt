package com.example.sawithub.ui.home

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.sawithub.R
import com.example.sawithub.databinding.ActivityHomeBinding
import com.example.sawithub.ui.riwayatKonsul.RiwayatKonsulFragment
import com.example.sawithub.ui.profile.ProfileFragment
import com.example.sawithub.ui.scan.ScanFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNav = binding.navView as BottomNavigationView

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_scan -> {
                    loadFragment(ScanFragment())
                    true
                }
                R.id.navigation_dashboard -> {
                    loadFragment(RiwayatKonsulFragment())
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}