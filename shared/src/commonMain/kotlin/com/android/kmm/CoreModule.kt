package com.android.kmm

import com.russhwolf.settings.Settings
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val coreModule = module {
    single { createSettings(get()) }
    single {
        HttpClient(createHttpEngineFactory()) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }
}

internal expect fun createSettings(config: DemoConfig): Settings

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>
