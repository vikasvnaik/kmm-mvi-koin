package com.android.kmm.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.android.kmm.Greeting
import com.android.kmm.presentation.home.HomeViewModel

val commonModule = module {
    singleOf(::Greeting)
    singleOf(::HomeViewModel)
}