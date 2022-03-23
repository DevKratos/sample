package com.amansour.sampleapplication.features.home.domain.repositories

import com.amansour.sampleapplication.features.home.domain.models.ApiResponse

interface HomeRepository {

    suspend fun getData(): ApiResponse

}