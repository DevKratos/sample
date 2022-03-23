package com.amansour.sampleapplication.features.home.data.api

import com.amansour.sampleapplication.features.home.domain.models.ApiResponse
import retrofit2.http.GET

interface DataApi {

    @GET("api/json-storage/bin/edfefba")
    suspend fun getData(): ApiResponse

}