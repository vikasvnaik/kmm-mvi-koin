package com.android.kmm.data.posts.model

import kotlinx.serialization.Serializable

@Serializable
data class PostJson(val id: Long, val userId: Long, val title: String, val body: String)

internal fun PostJson.asModel() = Post(id = id, userId = userId, title = title, body = body)
