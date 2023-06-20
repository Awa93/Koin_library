package com.example.koindemo.di.module

import com.example.koindemo.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}