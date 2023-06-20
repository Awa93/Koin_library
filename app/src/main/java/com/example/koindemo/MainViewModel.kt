package com.example.koindemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koindemo.model.User
import com.example.koindemo.repository.MainRepository
import com.example.koindemo.utils.NetworkHelper
import com.example.koindemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>>
        get() = _users

    init {
        fetchUsers()
    }

//    private fun fetchUsers() {
//        viewModelScope.launch {
//            _users.postValue(Resource.loading(null))
//            if (networkHelper.isNetworkConnected()) {
//                mainRepository.getUsers().let {
//                    if (it.isSuccessful) {
//                        _users.postValue(Resource.success(it.body()))
//                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
//                }
//            } else _users.postValue(Resource.error("No internet connection", null))
//        }
//    }

    private fun fetchUsers(){
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().flowOn(Dispatchers.IO)
                    .catch { }
                    .collect {
                        if (it.isSuccessful) {
                            _users.postValue(Resource.success(it.body()))
                        } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                    }
            }else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}