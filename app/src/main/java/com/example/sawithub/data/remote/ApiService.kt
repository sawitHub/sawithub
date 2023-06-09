package com.example.sawithub.data.remote

import com.example.sawithub.data.response.LoginResponse
import com.example.sawithub.data.response.PenyakitResponse
import com.example.sawithub.data.response.PenyakitResponseItem
import com.example.sawithub.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

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

    @GET("/user-sawitHub/penyakitSawit.json")
    fun getPenyakit(): Call<List<PenyakitResponseItem>>
}