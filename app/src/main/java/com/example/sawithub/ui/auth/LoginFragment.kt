package com.example.sawithub.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.sawithub.R
import com.example.sawithub.databinding.FragmentLoginBinding
import com.example.sawithub.ui.home.HomeActivity
import com.example.sawithub.ui.home.HomeFragment

class LoginFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel by viewModels<LoginViewModel>()

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
            btnLogin.setOnClickListener {
                initView()
            }
        }
    }

    override fun onClick(p0: View) {
        if (p0.id == R.id.text_to_signup) {
            val signUpFragment = SignUpFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.auth_container, signUpFragment, SignUpFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    fun initView() {
        val email = binding.inputEmailLogin.text.toString()
        val password = binding.inputPasswordLogin.text.toString()
        when{
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(requireActivity(), "mohon isi email atau password", Toast.LENGTH_SHORT).show()
            }
            else -> {
                loginViewModel.setLogin(email, password)
            }
        }
        initObserver()
    }

    fun initObserver() {
        loginViewModel.userLogin.observe(viewLifecycleOwner){
            if (it != null) {
                val intent = Intent(requireActivity(), HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                requireActivity().finish()
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