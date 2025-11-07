package dev.aaa1115910.biliapi.repositories

import dev.aaa1115910.biliapi.http.BiliHttpApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class SponsorRepositoryTest {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                coerceInputValues = true
                ignoreUnknownKeys = true
                allowStructuredMapKeys = true
            })
        }
    }
    private val sponsorRepository = SponsorRepository(client)

    @Test
    fun `get skip segments`() {
        runBlocking {
            runCatching {
                withTimeout(5000) {
                    val result = sponsorRepository.getSkipSegments(
                        bvId = "BV1jW4y197BF",
                        cid = 850324542
                    )
                    println(result)
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
