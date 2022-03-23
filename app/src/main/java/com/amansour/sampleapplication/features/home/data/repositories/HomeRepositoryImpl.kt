package com.amansour.sampleapplication.features.home.data.repositories

import com.amansour.sampleapplication.features.home.data.api.DataApi
import com.amansour.sampleapplication.features.home.domain.models.ApiResponse
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeApi: DataApi) : HomeRepository {
    override suspend fun getData(): ApiResponse {
        return homeApi.getData()
    }
}