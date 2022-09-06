package loc.example.simplifyingandroiddev9522.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val page: Int? = null,
    val results: List<MovieResponse>? = null,
    @SerialName("total_results") val totalResults: Int? = null,
    @SerialName("total_pages") val totalPages: Int? = null
)
