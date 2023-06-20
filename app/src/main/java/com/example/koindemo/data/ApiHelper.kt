package com.example.koindemo.data

import com.example.koindemo.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}
