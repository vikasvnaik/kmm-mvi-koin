package com.android.kmm.presentation.home

import com.android.kmm.domain.posts.GetPostsUseCase
import com.android.kmm.mvi.KmmStateFlow
import com.android.kmm.mvi.KmmViewModel
import com.android.kmm.mvi.asKmmStateFlow
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel internal constructor(
    private val postsUseCase: GetPostsUseCase
): KmmViewModel() {
    private val exceptionHandler = CoroutineExceptionHandler { _, e -> handleException(e) }
    private val _uiState = MutableStateFlow(HomeUiState.default())
    val uiState: KmmStateFlow<HomeUiState> = _uiState.asKmmStateFlow()

    private fun collectPosts() = scope.launch(exceptionHandler) {
        postsUseCase().collectLatest { posts ->
            val uiPosts = posts.map { it.asUiState() }
            _uiState.update { it.copy(isLoading = false, posts = uiPosts) }
        }
    }

    private fun handleException(e: Throwable) {
        _uiState.update { it.copy(isLoading = false, error = e) }
    }
}