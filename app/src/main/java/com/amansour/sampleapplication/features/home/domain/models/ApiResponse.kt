package com.amansour.sampleapplication.features.home.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse(
    @SerialName("stories")
    val stories: List<Story>?,
    @SerialName("videos")
    val videos: List<Video>?
)

@Serializable
data class Story(
    @SerialName("author")
    val author: String,
    @SerialName("date")
    val date: Double,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("sport")
    val sport: Sport,
    @SerialName("teaser")
    val teaser: String,
    @SerialName("title")
    val title: String
)

@Serializable
data class Video(
    @SerialName("date")
    val date: Double,
    @SerialName("id")
    val id: Int,
    @SerialName("sport")
    val sport: Sport,
    @SerialName("thumb")
    val thumb: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String,
    @SerialName("views")
    val views: Int
)

@Serializable
data class Sport(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)