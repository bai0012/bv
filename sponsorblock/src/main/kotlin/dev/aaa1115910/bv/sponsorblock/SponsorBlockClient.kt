package dev.aaa1115910.bv.sponsorblock

import dev.aaa1115910.bv.sponsorblock.entity.Segment
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import dev.aaa1115910.bv.sponsorblock.entity.SponsorBlockSettings
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SponsorBlockClient {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getSkipSegments(
        bvId: String,
        cid: String,
        sponsorBlockSettings: SponsorBlockSettings
    ): List<Segment> {
        if (!sponsorBlockSettings.enabled) return emptyList()
        return client.get("https://bsbsb.top/api/skipSegments") {
            parameter("videoID", bvId)
            parameter("cid", cid)
            parameter("categories", sponsorBlockSettings.categories.joinToString(","))
        }.body()
    }
}
