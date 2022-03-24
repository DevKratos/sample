package com.amansour.sampleapplication.features.video.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amansour.sampleapplication.features.video.domain.usecases.VideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(private val videoUseCase: VideoUseCase) : ViewModel() {

    val videoUrl = MutableLiveData<String?>()

    fun setId(id: Int) {
        viewModelScope.launch {
            videoUrl.value = videoUseCase.invoke(id)
        }
    }
}