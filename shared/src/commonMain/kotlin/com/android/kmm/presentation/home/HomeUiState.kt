package com.android.kmm.presentation.home

import com.android.kmm.data.posts.model.Post

data class HomeUiState(
    val posts: List<PostUiState>,
    val isLoading: Boolean,
    val isLoggedOut: Boolean,
    val error: Throwable?,
) {

    companion object {

        fun default() = HomeUiState(
            posts = emptyList(),
            isLoading = true,
            isLoggedOut = false,
            error = null,
        )
    }
}

data class PostUiState(
    val id: Long,
    val title: String,
    val body: String,
)

internal fun Post.asUiState() = PostUiState(
    id = id,
    title = title,
    body = body,
)
