package com.maks.youtubevideoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.maks.youtubevideoplayer.databinding.ActivityMainBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpYoutubeVideoPlayer()
    }

    private fun setUpYoutubeVideoPlayer() {

        val youTubePlayerView = YouTubePlayerView(this)
        binding.lltop.addView(youTubePlayerView)

        lifecycle.addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "S0Q4gqBUs7c"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

    }
}