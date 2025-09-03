package dev.aaa1115910.bv.player.factory

import android.content.Context
import dev.aaa1115910.bv.player.AbstractVideoPlayer
import dev.aaa1115910.bv.player.VideoPlayerOptions

import dev.aaa1115910.bv.sponsorblock.entity.SponsorBlockSettings

abstract class PlayerFactory<T : AbstractVideoPlayer> {
    abstract fun create(
        context: Context,
        options: VideoPlayerOptions,
        sponsorBlockSettings: SponsorBlockSettings
    ): T
}