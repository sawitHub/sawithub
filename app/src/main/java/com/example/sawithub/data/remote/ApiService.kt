package com.example.sawithub.data.remote

import com.example.sawithub.data.response.LoginResponse
import com.example.sawithub.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("Name") Name: String,
        @Field("Email") Email: String,
        @Field("Password") Password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("Email") Email: String,
        @Field("Password") Password: String
    ): Call<LoginResponse>
}