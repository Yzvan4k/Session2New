package com.example.myapplication3

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("signIn")
    fun postIn(@Body b :LogB): Call<UserData>
    @POST("signUp")
    fun postUp(@Body b :RegB): Call<UserData>
}