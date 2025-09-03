package dev.aaa1115910.bv.player.entity

import androidx.compose.runtime.compositionLocalOf
import dev.aaa1115910.biliapi.entity.danmaku.DanmakuMaskFrame
import dev.aaa1115910.biliapi.entity.video.Subtitle
import dev.aaa1115910.bv.sponsorblock.entity.Segment

val LocalVideoPlayerStateData = compositionLocalOf { VideoPlayerStateData() }
val LocalVideoPlayerSeekData = compositionLocalOf { VideoPlayerSeekData() }
val LocalVideoPlayerConfigData = compositionLocalOf { VideoPlayerConfigData() }
val LocalVideoPlayerDebugInfoData = compositionLocalOf { VideoPlayerDebugInfoData() }
val LocalVideoPlayerClockData = compositionLocalOf { VideoPlayerClockData() }
val LocalVideoPlayerVideoInfoData = compositionLocalOf { VideoPlayerVideoInfoData() }
val LocalVideoPlayerHistoryData = compositionLocalOf { VideoPlayerHistoryData() }
val LocalVideoPlayerLoadStateData = compositionLocalOf { VideoPlayerLoadStateData() }
val LocalVideoPlayerLogsData = compositionLocalOf { VideoPlayerLogsData() }
val LocalVideoPlayerDanmakuMasksData = compositionLocalOf { VideoPlayerDanmakuMasksData() }
val LocalSponsorBlockSegmentsData = compositionLocalOf<List<Segment>> { emptyList() }

data class VideoPlayerStateData(
    val isPlaying: Boolean = false,
    val isBuffering: Boolean = false,
    val isError: Boolean = false,
    val exception: Exception? = null,
    val showBackToHistory: Boolean = false,
)

data class VideoPlayerSeekData(
    val duration: Long = 0,
    val position: Long = 0,
    val bufferedPercentage: Int = 0
)

data class VideoPlayerConfigData(
    val availableResolutions: List<Resolution> = emptyList(),
    val currentResolution: Resolution = Resolution.R1080P,
    val availableVideoCodec: List<VideoCodec> = emptyList(),
    val currentVideoCodec: VideoCodec = VideoCodec.AVC,
    val availableAudios: List<Audio> = emptyList(),
    val currentAudio: Audio = Audio.A192K,
    val availableVideoList: List<VideoListItem> = emptyList(),
    val currentVideo: VideoListItem? = null,
    val availableSubtitles: List<Subtitle> = emptyList(),
    val currentSubtitleId: Long = -1,
    val currentVideoSpeed: Float = 1f,
    val currentDanmakuEnabled: Boolean = true,
    val currentDanmakuEnabledList: List<DanmakuType> = listOf(DanmakuType.All),
    val currentDanmakuScale: Float = 1f,
    val currentDanmakuOpacity: Float = 1f,
    val currentDanmakuArea: Float = 1f,
    val currentDanmakuMask: Boolean = false,
    val currentSubtitleFontSize: Int = 24,
    val currentSubtitleBackgroundOpacity: Float = 0.4f,
    val currentSubtitleBottomPadding: Int = 12,
    val incognitoMode: Boolean = false
)

data class VideoPlayerDebugInfoData(
    val debugInfo: String = ""
)

data class VideoPlayerClockData(
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0
)

data class VideoPlayerVideoInfoData(
    val title: String = "",
    val partTitle: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val videoShot: Any? = null
)

data class VideoPlayerHistoryData(
    val lastPlayed: Int = 0
)

data class VideoPlayerLoadStateData(
    val loadState: RequestState = RequestState.Ready,
    val errorMessage: String = ""
)

data class VideoPlayerLogsData(
    val logs: String = ""
)

data class VideoPlayerDanmakuMasksData(
    val danmakuMasks: List<DanmakuMaskFrame> = emptyList()
)
