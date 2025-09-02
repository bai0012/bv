package dev.aaa1115910.bv.sponsorblock

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Segment(
    @SerialName("segment")
    val segment: List<Float>,
    @SerialName("cid")
    val cid: String,
    @SerialName("UUID")
    val uuid: String,
    @SerialName("category")
    val category: String,
    @SerialName("actionType")
    val actionType: String,
    @SerialName("locked")
    val locked: Int,
    @SerialName("votes")
    val votes: Int,
    @SerialName("videoDuration")
    val videoDuration: Int
)

@Serializable
data class Video(
    @SerialName("videoID")
    val videoId: String,
    @SerialName("hash")
    val hash: String,
    @SerialName("segments")
    val segments: List<Segment>
)
