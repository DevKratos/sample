package com.amansour.sampleapplication.features.home.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amansour.sampleapplication.features.home.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    val viewModel by viewModels<HomeViewModel>()


}