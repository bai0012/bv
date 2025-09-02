package dev.aaa1115910.bv.player.seekbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aaa1115910.bv.sponsorblock.Segment

val sponsorBlockCategoryColors = mapOf(
    "sponsor" to Color(0xFF00FF00),
    "intro" to Color(0xFF00FFFF),
    "outro" to Color(0xFF0000FF),
    "interaction" to Color(0xFFFF00FF),
    "selfpromo" to Color(0xFFFFFF00),
    "music_offtopic" to Color(0xFFFFA500),
    "preview" to Color(0xFF800080),
    "poi_highlight" to Color(0xFF008000),
    "filler" to Color(0xFF808080),
    "exclusive_access" to Color(0xFFADD8E6),
    "chapter" to Color(0xFFF0E68C)
)

@Composable
fun SeekBar(
    modifier: Modifier = Modifier,
    duration: Long,
    position: Long,
    bufferedPercentage: Int,
    colors: SliderColors = SliderDefaults.colors(),
    sponsorBlockSegments: List<Segment> = emptyList()
) {
    val trackWidth = 32f
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(trackWidth.dp)
    ) {
        drawLine(
            color = colors.inactiveTrackColor,
            start = Offset(0f, center.y),
            end = Offset(size.width - 0f, center.y),
            strokeWidth = trackWidth,
            cap = StrokeCap.Round
        )
        drawLine(
            color = colors.disabledActiveTrackColor,
            start = Offset(0f, center.y),
            end = Offset(size.width * bufferedPercentage / 100, center.y),
            strokeWidth = trackWidth,
            cap = StrokeCap.Round
        )

        sponsorBlockSegments.forEach { segment ->
            val startFraction = segment.segment[0] / duration.toFloat()
            val endFraction = segment.segment[1] / duration.toFloat()
            val startOffset = size.width * startFraction
            val endOffset = size.width * endFraction

            drawLine(
                color = sponsorBlockCategoryColors[segment.category] ?: Color.Transparent,
                start = Offset(startOffset, center.y),
                end = Offset(endOffset, center.y),
                strokeWidth = trackWidth,
                cap = StrokeCap.Butt
            )
        }

        drawLine(
            color = colors.activeTrackColor,
            start = Offset(0f, center.y),
            end = Offset(size.width * (position / duration.toFloat()), center.y),
            strokeWidth = trackWidth,
            cap = StrokeCap.Round
        )
    }
}

@Preview
@Composable
private fun SeekPreview() {
    MaterialTheme {
        SeekBar(
            modifier = Modifier.padding(horizontal = 16.dp),
            duration = 1000,
            position = 300,
            bufferedPercentage = 50
        )
    }
}