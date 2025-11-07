package dev.aaa1115910.biliapi.repositories

import dev.aaa1115910.biliapi.entity.sponsor.Segment
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.annotation.Single

@Single
class SponsorRepository(
    private val client: HttpClient
) {
    suspend fun getSkipSegments(
        bvId: String,
        cid: Long,
    ): List<Segment> {
        return client.get("https://bsbsb.top/api/skipSegments") {
            parameter("videoID", bvId)
            parameter("cid", cid)
        }.body()
    }
}
