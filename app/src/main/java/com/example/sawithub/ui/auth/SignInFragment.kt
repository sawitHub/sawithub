package com.example.sawithub.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sawithub.R

class SignInFragment : Fragment(),View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textToLogin: TextView = view.findViewById(R.id.text_to_login)
        textToLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.text_to_login) {
            val loginFragment = LoginFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.auth_container, loginFragment, LoginFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}