package com.amansour.sampleapplication.features.details.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amansour.sampleapplication.features.details.domain.models.DetailsUi
import com.amansour.sampleapplication.features.details.domain.models.ShareModel
import com.amansour.sampleapplication.features.details.domain.usecases.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsUseCase: DetailsUseCase) :
    ViewModel() {

    val detailsData = MutableLiveData<DetailsUi>()

    val shareAction = MutableLiveData<ShareModel?>()

    fun setId(id: Int) {
        viewModelScope.launch {
            detailsData.value = detailsUseCase.invoke(id)
        }
    }

    fun onShareClicked() {
        shareAction.value = detailsData.value?.shareModel
    }
}