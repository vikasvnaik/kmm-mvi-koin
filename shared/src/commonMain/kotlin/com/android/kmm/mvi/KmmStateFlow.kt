package com.android.kmm.mvi

import kotlinx.coroutines.flow.StateFlow

expect class KmmStateFlow<T>(source: StateFlow<T>) : StateFlow<T>
