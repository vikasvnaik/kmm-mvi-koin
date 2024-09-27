package com.android.kmm.mvi

import kotlinx.coroutines.CoroutineScope
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

expect abstract class KmmViewModel constructor() {
    protected val scope: CoroutineScope
}