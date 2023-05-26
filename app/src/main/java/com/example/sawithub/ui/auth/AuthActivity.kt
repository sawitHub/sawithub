package com.example.sawithub.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sawithub.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        supportActionBar?.hide()

        val fragmentManager = supportFragmentManager
        val homeFragment = LoginFragment()
        val fragment = fragmentManager.findFragmentByTag(LoginFragment::class.java.simpleName)
        if (fragment !is LoginFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + LoginFragment::class.java.simpleName)
            fragmentManager
                .beginTransaction()
                .add(R.id.auth_container, homeFragment, LoginFragment::class.java.simpleName)
                .commit()
        }
    }
}