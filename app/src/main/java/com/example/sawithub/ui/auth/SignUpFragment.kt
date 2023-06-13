package com.example.sawithub.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.sawithub.R
import com.example.sawithub.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment(),View.OnClickListener {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textToLogin.setOnClickListener(this)
        binding.apply {
            btnSignup.setOnClickListener {
                initView()
            }
        }
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

    fun initView() {
        val name = binding.inputNameSignup.text.toString()
        val email = binding.inputEmailSignup.text.toString()
        val password = binding.inputPasswordSignup.text.toString()
        when{
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(requireActivity(), "mohon isi email atau password", Toast.LENGTH_SHORT).show()
            }
            else -> {
                signUpViewModel.setRegister(name, email, password)
            }
        }
        initObserver()
    }

    fun initObserver() {
        signUpViewModel.userRegister.observe(viewLifecycleOwner){
            if (it != null) {
                val loginFragment = LoginFragment()
                val fragmentManager = parentFragmentManager
                fragmentManager.beginTransaction().apply {
                    replace(R.id.auth_container, loginFragment, LoginFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
            else {
                Toast.makeText(requireActivity(), "login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}