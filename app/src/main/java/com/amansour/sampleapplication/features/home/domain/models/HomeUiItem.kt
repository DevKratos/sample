package com.amansour.sampleapplication.features.home.domain.models

data class HomeUiItem(
    val imageUrl: String,
    val imageTag: String,
    val title: String,
    val extras: String,
    var action: (() -> Unit)?
)