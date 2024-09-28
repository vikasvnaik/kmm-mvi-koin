package com.android.kmm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
fun appView(state: HomeUiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Posts")
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(state.posts, key = {it.id}) { post ->
                PostView(post.title, post.id, post.body)
            }
        }

    }
}

@Composable
private fun PostView(title: String, id: Long, body: String) {
    Column {
        Text(
            text = title,
            style = typography.h5,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = id.toString(),
            style = typography.caption,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
        )
        Text(
            text = body,
            style = typography.body1,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 4.dp, bottom = 16.dp)
        )
        Divider()
    }
}

