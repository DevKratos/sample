package com.amansour.sampleapplication.features.details.domain.usecases

import com.amansour.sampleapplication.BuildConfig
import com.amansour.sampleapplication.extensions.getPastDuration
import com.amansour.sampleapplication.features.details.domain.models.DetailsUi
import com.amansour.sampleapplication.features.details.domain.models.ShareModel
import com.amansour.sampleapplication.features.home.domain.models.Story
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(id: Int): DetailsUi? {
        return homeRepository.getData().stories?.firstOrNull { it.id == id }?.toDetailsUi()
    }
}

private fun Story.toDetailsUi(): DetailsUi {
    return DetailsUi(
        image,
        sport.name,
        title,
        author,
        (date * 1000).toLong().getPastDuration(),
        teaser,
        ShareModel("${sport.name} - $title", BuildConfig.SERVER_URL + id)
    )
}
