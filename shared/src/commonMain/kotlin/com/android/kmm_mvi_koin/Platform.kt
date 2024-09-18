package com.android.kmm_mvi_koin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform