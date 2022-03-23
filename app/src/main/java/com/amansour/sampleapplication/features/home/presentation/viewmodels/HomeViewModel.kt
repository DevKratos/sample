package com.amansour.sampleapplication.features.home.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amansour.sampleapplication.features.home.domain.models.HomeUiItem
import com.amansour.sampleapplication.features.home.domain.usecases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val homeData = MutableLiveData<List<HomeUiItem>>(listOf())

    init {
        viewModelScope.launch {
            isLoading.value = true
            val data = withContext(Dispatchers.IO) {
                homeUseCase.invoke()
            }
            homeData.value = data
            isLoading.value = false
        }

    }
}