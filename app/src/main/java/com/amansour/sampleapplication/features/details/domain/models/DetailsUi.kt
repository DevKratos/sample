package com.amansour.sampleapplication.features.details.domain.models

data class DetailsUi(
    val imageUrl: String,
    val tag: String,
    val title: String,
    val author: String,
    val date: String,
    val description: String,
    val shareModel: ShareModel
)