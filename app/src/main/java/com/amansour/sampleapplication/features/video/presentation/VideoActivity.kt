package com.amansour.sampleapplication.features.video.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.amansour.sampleapplication.R
import com.amansour.sampleapplication.databinding.ActivityVideoBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class VideoActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ID = "extra-id"
        fun getIntent(context: Context, id: Int): Intent {
            return Intent(context, VideoActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }

    private val viewModel by viewModels<VideoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            hideSystemBars()
        }
        val binding =
            DataBindingUtil.setContentView<ActivityVideoBinding>(this, R.layout.activity_video)

        setupVideo(binding)

        setupObservables(binding)

        setupArgs()
    }

    private fun setupVideo(binding: ActivityVideoBinding) {
        val controller = MediaController(this).apply {
            setAnchorView(binding.videoView)
        }

        binding.videoView.setMediaController(controller)
    }

    private fun setupArgs() {
        intent.getIntExtra(EXTRA_ID, -1).let {
            if (it == -1) {
                finish()
            } else {
                viewModel.setId(it)
            }
        }
    }

    private fun setupObservables(binding: ActivityVideoBinding) {
        viewModel.videoUrl.observe(this) {
            lifecycleScope.launchWhenResumed {
                binding.videoView.setVideoURI(Uri.parse(it))
                binding.videoView.start()
            }
        }
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}