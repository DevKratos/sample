package com.amansour.sampleapplication.features.home.domain.repositories

import com.amansour.sampleapplication.features.home.domain.models.ApiResponse
import retrofit2.http.GET

interface HomeRepository {

    suspend fun getData() : ApiResponse

}