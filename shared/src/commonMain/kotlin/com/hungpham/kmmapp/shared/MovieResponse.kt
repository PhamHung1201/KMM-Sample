package com.hungpham.kmmapp.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("results") val results: List<Movie>
)