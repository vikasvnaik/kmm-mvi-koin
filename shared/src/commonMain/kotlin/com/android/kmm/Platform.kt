package com.android.kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform