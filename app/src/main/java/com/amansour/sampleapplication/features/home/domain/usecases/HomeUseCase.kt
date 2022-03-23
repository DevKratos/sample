package com.amansour.sampleapplication.features.home.domain.usecases

import com.amansour.sampleapplication.extensions.mergeLists
import com.amansour.sampleapplication.features.home.domain.models.HomeUiItem
import com.amansour.sampleapplication.features.home.domain.models.Story
import com.amansour.sampleapplication.features.home.domain.models.Video
import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke(): List<HomeUiItem> {
        val data = homeRepository.getData()

        val stories = data.stories?.map { it.toHomeUi() } ?: listOf()
        val videos = data.videos?.map { it.toHomeUi() } ?: listOf()

        return mergeLists(stories, videos)
    }
}

private fun Video.toHomeUi(): HomeUiItem {
    return HomeUiItem(id, thumb, sport.name, title, "$views")
}

private fun Story.toHomeUi(): HomeUiItem {
    return HomeUiItem(id, image, sport.name, title, "$date")
}
