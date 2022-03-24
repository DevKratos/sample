package com.amansour.sampleapplication.features.home.domain.models

data class HomeUiItem(
    val id: Int,
    val imageUrl: String,
    val imageTag: String,
    val title: String,
    val extras: String,
    val showPlay: Boolean = false,
    var action: (() -> Unit)? = null
)