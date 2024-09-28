package com.android.kmm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.kmm.presentation.home.HomeUiState
import com.android.kmm.presentation.home.HomeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App(homeViewModel: HomeViewModel = koinInject()) {
    val state by homeViewModel.uiState.collectAsState()
    appView(state = state)
}

@Composable
fun appView(state: HomeUiState){
    state.posts
    println("Posts data : " +state.posts)
}
