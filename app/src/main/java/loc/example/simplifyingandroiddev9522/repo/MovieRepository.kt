package loc.example.simplifyingandroiddev9522.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import loc.example.simplifyingandroiddev9522.api.MovieApi
import loc.example.simplifyingandroiddev9522.api.response.toMovieList
import loc.example.simplifyingandroiddev9522.model.Movie
import kotlin.coroutines.CoroutineContext

interface MovieRepo {
    suspend fun fetchMovies(): List<Movie>
}

class MovieRepository(
    private val api: MovieApi,
    private val ioDispatcher: CoroutineContext = Dispatchers.IO
) : MovieRepo {
    override suspend fun fetchMovies(): List<Movie> = withContext(ioDispatcher) {
        api.getMovieList().toMovieList()
    }
}