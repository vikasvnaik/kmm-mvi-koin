package com.android.kmm.data.posts

import com.android.kmm.data.posts.model.PostJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PostApiImpl(private val client: HttpClient): PostsApi {
    override suspend fun fetchAllPosts(): List<PostJson> {
        return client.get("https://jsonplaceholder.typicode.com/posts").body()
    }
}