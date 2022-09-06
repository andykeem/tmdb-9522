package loc.example.simplifyingandroiddev9522.repo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import loc.example.simplifyingandroiddev9522.BaseTest
import loc.example.simplifyingandroiddev9522.api.MovieApi
import loc.example.simplifyingandroiddev9522.api.response.MovieResponse
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertEquals
import kotlin.test.assertFalse

@OptIn(ExperimentalCoroutinesApi::class)
class MovieRepositoryTest : BaseTest() {
    private lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        val movieList = (1..3).map { MovieResponse(id = it, title = "Movie Title $it") }
        val mockedApi = mock<MovieApi> {
            onBlocking { getMovieList() } doReturn movieList
        }
        repository = MovieRepository(api = mockedApi)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test() = runTest {
        val movies = repository.fetchMovies()
        println("movies: $movies")
        assertFalse(movies.isEmpty())
        assertEquals(3, movies.size)
    }
}