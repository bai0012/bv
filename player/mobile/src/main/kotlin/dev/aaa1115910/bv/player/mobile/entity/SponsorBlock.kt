package dev.aaa1115910.bv.player.mobile.controller

import androidx.compose.runtime.staticCompositionLocalOf
import dev.aaa1115910.bv.sponsorblock.Segment

data class VideoPlayerSponsorBlockData(
    val segments: List<Segment> = emptyList()
)

val LocalVideoPlayerSponsorBlockData = staticCompositionLocalOf { VideoPlayerSponsorBlockData() }
