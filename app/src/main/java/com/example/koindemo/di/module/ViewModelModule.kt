package com.example.koindemo.di.module

import com.example.koindemo.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get(),get())
    }
}