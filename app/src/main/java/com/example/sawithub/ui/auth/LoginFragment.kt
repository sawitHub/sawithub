package com.example.sawithub.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sawithub.R

class LoginFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textToSignIn:TextView = view.findViewById(R.id.text_to_signup)
        textToSignIn.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.text_to_signup) {
            val signInFragment = SignInFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.auth_container, signInFragment, SignInFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}