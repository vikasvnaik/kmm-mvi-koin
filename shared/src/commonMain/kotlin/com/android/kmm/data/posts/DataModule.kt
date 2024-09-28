package com.android.kmm.data.posts

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val  dataModule = module{
    singleOf(::PostsRepository)
    factoryOf(::PostApiImpl) bind PostsApi::class
}