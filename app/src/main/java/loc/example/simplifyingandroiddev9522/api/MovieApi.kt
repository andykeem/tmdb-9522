package loc.example.simplifyingandroiddev9522.api

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import loc.example.simplifyingandroiddev9522.api.response.MovieListResponse
import loc.example.simplifyingandroiddev9522.api.response.MovieResponse
import okhttp3.logging.HttpLoggingInterceptor

private const val TAG = "MovieApi"
private const val ENDPOINT = "https://api.themoviedb.org/4"
private const val TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjZjM3MjIzOGY0N2M5OTI0ZmMxZDFhNWZhMTk3NWU2NCIsInN1YiI6IjVkYTQ5MTFmZTg2MDE3MDAxN2IyZDUxOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8k5_5muSsq9_ZCPfCaEETbP7YqRLAarD5hqG7J1raZQ"

interface MovieApi {
    suspend fun getMovieList(): List<MovieResponse>
}

class MovieApiImpl : MovieApi {
    private val client = HttpClient(OkHttp) {
//        install(Auth) {
//            bearer {
//                BearerTokens(TOKEN, TOKEN)
//            }
//        }
        install(ContentNegotiation) {
            json(json = Json { ignoreUnknownKeys = true })
        }
        install(Logging)
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.themoviedb.org"
                path("3/")
            }
            header("Authorization", "Bearer $TOKEN")
        }
        engine {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(interceptor)
        }
    }

    override suspend fun getMovieList(): List<MovieResponse> {
        val url = "movie/popular"
        val resp = client.get(url)
        Log.d(TAG, "getMovieList: resp: $resp")
        val body: MovieListResponse = resp.body()
        Log.d(TAG, "getMovieList: body: $body")
        val list = body.results.orEmpty()
        Log.d(TAG, "getMovieList: num movies: ${list.size}")
        return list
    }
}