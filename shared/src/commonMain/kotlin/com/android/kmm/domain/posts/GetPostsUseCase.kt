package com.android.kmm.domain.posts

import com.android.kmm.data.posts.PostsRepository
import com.android.kmm.data.posts.model.Post
import kotlinx.coroutines.flow.Flow

internal class GetPostsUseCase(
    private val postsRepository: PostsRepository
) {
    operator fun invoke(): Flow<List<Post>>{
        return postsRepository.getAllPosts()
    }
}