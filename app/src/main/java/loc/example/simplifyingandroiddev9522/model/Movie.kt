package loc.example.simplifyingandroiddev9522.model

import kotlinx.datetime.LocalDate

data class Movie(
    val posterPath: String = "",
    val adult: Boolean = false,
    val overview: String = "",
    val releaseDate: LocalDate? = null,
    val genreIds: List<Int> = emptyList(),
    val id: Int = 0,
    val origTitle: String = "",
    val origLan: String = "",
    val title: String = "",
    val backdropPath: String = "",
    val popularity: Double = 0.00,
    val voteCnt: Int = 0,
    val video: Boolean = false,
    val voteAvg: Double = 0.00
) {
    val posterUrl: String
        get() = "$POSTER_BASE_URL$posterPath"

    val backdropUrl: String
        get() = "$POSTER_BASE_URL$backdropPath"

    companion object {
        private const val POSTER_BASE_URL =
            "https://image.tmdb.org/t/p/w500" // "https://image.tmdb.org/t/p/original"
    }
}

