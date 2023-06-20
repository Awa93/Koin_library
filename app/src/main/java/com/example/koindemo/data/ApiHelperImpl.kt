package com.example.koindemo.data

import com.example.koindemo.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiServices: ApiServices):ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiServices.getUser()
}