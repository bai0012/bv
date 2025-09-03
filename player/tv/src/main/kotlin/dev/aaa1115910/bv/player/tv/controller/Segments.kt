package dev.aaa1115910.bv.player.tv.controller

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.aaa1115910.bv.sponsorblock.entity.Segment

@Composable
fun Segments(
    modifier: Modifier = Modifier,
    segments: List<Segment>,
    duration: Long
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        segments.forEach { segment ->
            val start = size.width * (segment.segment[0] / duration)
            val end = size.width * (segment.segment[1] / duration)
            drawRect(
                color = when (segment.category) {
                    "sponsor" -> Color.Green
                    "selfpromo" -> Color.Yellow
                    "interaction" -> Color.Cyan
                    "intro" -> Color.Blue
                    "outro" -> Color.Magenta
                    "preview" -> Color.Red
                    "music_offtopic" -> Color.Gray
                    "poi_highlight" -> Color.White
                    "filler" -> Color.DarkGray
                    "exclusive_access" -> Color.LightGray
                    "chapter" -> Color.Black
                    else -> Color.Transparent
                },
                topLeft = androidx.compose.ui.geometry.Offset(start, 0f),
                size = androidx.compose.ui.geometry.Size(end - start, size.height)
            )
        }
    }
}
