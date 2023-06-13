package com.example.sawithub.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sawithub.data.remote.ApiConfig
import com.example.sawithub.data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _userLogin= MutableLiveData<LoginResponse>()
    val userLogin: LiveData<LoginResponse> = _userLogin

    fun setLogin(email:String, password:String){
        val retro = ApiConfig.getRetrofitClientInstance()
        retro.postLogin(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.isSuccessful){
                    _userLogin.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("LoginViewModel", "error ${t.message.toString()}")
            }

        })
    }
}