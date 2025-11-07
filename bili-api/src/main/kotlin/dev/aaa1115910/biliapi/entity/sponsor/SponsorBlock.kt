package dev.aaa1115910.biliapi.entity.sponsor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Segment(
    @SerialName("segment")
    val segment: List<Float>,
    @SerialName("UUID")
    val uuid: String,
    val category: String,
    @SerialName("actionType")
    val actionType: String,
    val locked: Int,
    val votes: Int,
    @SerialName("videoDuration")
    val videoDuration: Int
)
