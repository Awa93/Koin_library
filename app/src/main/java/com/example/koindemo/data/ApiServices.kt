package com.example.koindemo.data

import com.example.koindemo.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("users")
    suspend fun getUser(): Response<List<User>>
}