package com.android.kmm.domain

import com.android.kmm.domain.posts.GetPostsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val domainModule = module {
    factoryOf(::GetPostsUseCase)
}