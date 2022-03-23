package com.amansour.sampleapplication.features.details.domain.usecases

import com.amansour.sampleapplication.features.details.domain.models.DetailsUi
import com.amansour.sampleapplication.features.home.domain.models.Story
import com.amansour.sampleapplication.features.home.domain.models.Video
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(id: Int): DetailsUi? {
        return homeRepository.getData().stories?.firstOrNull { it.id == id }?.toDetailsUi()
            ?: homeRepository.getData().videos?.firstOrNull { it.id == id }?.toDetailsUi()
    }
}


private fun Video.toDetailsUi(): DetailsUi {
    return DetailsUi(thumb, title)
}

private fun Story.toDetailsUi(): DetailsUi {
    return DetailsUi(image, title)
}
