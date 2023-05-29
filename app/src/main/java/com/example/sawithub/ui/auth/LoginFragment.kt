package com.example.sawithub.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sawithub.R
import com.example.sawithub.databinding.FragmentLoginBinding
import com.example.sawithub.ui.home.HomeActivity

class LoginFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textToSignIn:TextView = view.findViewById(R.id.text_to_signup)
        textToSignIn.setOnClickListener(this)
        binding.apply {
            btnLogin.setOnClickListener { startActivity(Intent(activity, HomeActivity::class.java)) }
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}