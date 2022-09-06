package loc.example.simplifyingandroiddev9522.api.response

import kotlinx.datetime.toLocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import loc.example.simplifyingandroiddev9522.model.Movie

@Serializable
data class MovieResponse(
    @SerialName("poster_path") val posterPath: String? = null,
    val adult: Boolean? = null,
    val overview: String? = null,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("genre_ids") val genreIds: List<Int>? = null,
    val id: Int? = null,
    @SerialName("original_title") val originalTitle: String? = null,
    @SerialName("original_language") val originalLanguage: String? = null,
    val title: String? = null,
    @SerialName("backdrop_path") val backdropPath: String? = null,
    val popularity: Double? = null,
    @SerialName("vote_count") val voteCount: Int? = null,
    val video: Boolean? = null,
    @SerialName("vote_average") val voteAverage: Double? = null
)

fun List<MovieResponse>.toMovieList() = map {
    Movie(
        posterPath = it.posterPath.orEmpty(),
        adult = it.adult ?: false,
        overview = it.overview.orEmpty(),
        releaseDate = it.releaseDate?.toLocalDate(),
        genreIds = it.genreIds.orEmpty(),
        id = it.id ?: 0,
        origTitle = it.originalTitle.orEmpty(),
        origLan = it.originalLanguage.orEmpty(),
        title = it.title.orEmpty(),
        backdropPath = it.backdropPath.orEmpty(),
        popularity = it.popularity ?: 0.00,
        voteCnt = it.voteCount ?: 0,
        video = it.video ?: false,
        voteAvg = it.voteAverage ?: 0.00
    )
}