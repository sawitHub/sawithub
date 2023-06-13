package com.example.sawithub.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sawithub.data.remote.ApiConfig
import com.example.sawithub.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel(){

    private val _userRegister= MutableLiveData<RegisterResponse>()
    val userRegister: LiveData<RegisterResponse> = _userRegister

    fun setRegister(name: String, email:String, password:String){
        val retro = ApiConfig.getRetrofitClientInstance()
        retro.postRegister(name, email, password).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    _userRegister.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e("SignUpViewModel", "error ${t.message.toString()}")
            }

        })
    }
}