package com.amansour.sampleapplication.features.video.domain.usecases

import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class VideoUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(id: Int): String? {
        return homeRepository.getData().videos?.firstOrNull { it.id == id }?.url
    }

}