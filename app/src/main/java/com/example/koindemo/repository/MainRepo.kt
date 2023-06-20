package com.example.koindemo.repository

import com.example.koindemo.data.ApiHelper
import kotlinx.coroutines.flow.flow

class MainRepository (private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  flow{  emit(apiHelper.getUsers())}

}