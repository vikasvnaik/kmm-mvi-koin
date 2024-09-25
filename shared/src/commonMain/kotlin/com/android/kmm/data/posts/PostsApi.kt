package com.android.kmm.data.posts

import com.android.kmm.data.posts.model.PostJson

internal interface PostsApi {
    suspend fun fetchAllPosts(): List<PostJson>
}