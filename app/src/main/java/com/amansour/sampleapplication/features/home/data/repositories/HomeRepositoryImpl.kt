package com.amansour.sampleapplication.features.home.data.repositories

import com.amansour.sampleapplication.features.home.data.api.DataApi
import com.amansour.sampleapplication.features.home.domain.models.ApiResponse
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeApi: DataApi) : HomeRepository {
    //Keep data in ram for fast access.
    var dataHolder: ApiResponse? = null

    override suspend fun getData(): ApiResponse {

        return try {
            dataHolder ?: homeApi.getData().also {
                dataHolder = it
            }
        } catch (e: Exception){
            ApiResponse(null, null)
        }
    }
}