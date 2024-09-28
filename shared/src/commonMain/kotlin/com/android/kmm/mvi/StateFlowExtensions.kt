package com.android.kmm.mvi

import kotlinx.coroutines.flow.StateFlow

internal fun <T> StateFlow<T>.asKmmStateFlow() = KmmStateFlow(this)
