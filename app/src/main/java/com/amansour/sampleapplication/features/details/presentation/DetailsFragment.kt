package com.amansour.sampleapplication.features.details.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.amansour.sampleapplication.MainActivity
import com.amansour.sampleapplication.databinding.FragmentDetailsBinding
import com.amansour.sampleapplication.features.details.domain.models.ShareModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private val viewModel by viewModels<DetailsViewModel>()
    private val detailsArgs by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDetailsBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@DetailsFragment.viewModel
            this@DetailsFragment.viewModel.setId(detailsArgs.id)

            setupObservables()

            setupToolbar()

        }.root
    }

    private fun FragmentDetailsBinding.setupToolbar() {
        (requireActivity() as MainActivity).setSupportActionBar(detailsToolbar)
        (requireActivity() as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupObservables() {
        viewModel.shareAction.observe(viewLifecycleOwner) {
            it?.let { share ->
                launchShare(share)
            }
        }
    }

    private fun launchShare(share: ShareModel) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, share.title)
            putExtra(Intent.EXTRA_TEXT, share.url)
        })
    }


}