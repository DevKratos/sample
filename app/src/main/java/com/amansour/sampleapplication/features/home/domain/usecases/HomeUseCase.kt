package com.amansour.sampleapplication.features.home.domain.usecases

import com.amansour.sampleapplication.features.home.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend operator fun invoke() /*: UIData*/{

    }
}