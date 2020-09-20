package com.hungpham.kmmapp.shared.network

import com.hungpham.kmmapp.shared.MovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class MovieApi {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json {
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }
    }

    companion object {
        private const val UPCOMING_MOVIE_ENDPOINT = "https://api.themoviedb.org/3//movie/upcoming"
    }

    suspend fun getUpcomingMovie(): MovieResponse {
        return httpClient.get(UPCOMING_MOVIE_ENDPOINT)
    }
}