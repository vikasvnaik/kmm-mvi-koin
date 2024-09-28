package com.android.kmm.di

import com.android.kmm.coreModule
import com.android.kmm.data.posts.dataModule
import com.android.kmm.domain.domainModule

fun appModule() = listOf(coreModule, commonModule, domainModule, dataModule)