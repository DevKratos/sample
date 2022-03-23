package com.amansour.sampleapplication.features.home.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.amansour.sampleapplication.databinding.FragmentHomeBinding
import com.amansour.sampleapplication.features.home.presentation.adapters.HomeAdapter
import com.amansour.sampleapplication.features.home.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentHomeBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = viewModel
        }.also {
            setupAdapter(it)
        }.root
    }

    private fun setupAdapter(binding: FragmentHomeBinding) {
        val adapter = HomeAdapter()
        binding.homeRecycler.adapter = adapter
        viewModel.homeData.observe(viewLifecycleOwner) {
            adapter.items = it.map { it.copy { setupNavigation(it.id) } }
        }
    }

    private fun setupNavigation(id: Int) {
        findNavController().navigate(HomeFragmentDirections.homeToDetails(id))
    }


}