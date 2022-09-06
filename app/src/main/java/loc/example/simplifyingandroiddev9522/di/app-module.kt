package loc.example.simplifyingandroiddev9522.di

import kotlinx.coroutines.Dispatchers
import loc.example.simplifyingandroiddev9522.api.MovieApi
import loc.example.simplifyingandroiddev9522.api.MovieApiImpl
import loc.example.simplifyingandroiddev9522.repo.MovieRepo
import loc.example.simplifyingandroiddev9522.repo.MovieRepository
import loc.example.simplifyingandroiddev9522.viewmodel.MovieListViewModel
import loc.example.simplifyingandroiddev9522.widget.MovieGridAdapter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

private const val DISPATCHER_ID = "DISPATCHER_ID"

val appModule = module {
    singleOf(::MovieApiImpl) { bind<MovieApi>() }
    single<MovieRepo> { MovieRepository(get(), get(named(DISPATCHER_ID))) }
    viewModelOf(::MovieListViewModel)
    singleOf(::MovieGridAdapter)
    single<CoroutineContext>(named(DISPATCHER_ID)) { Dispatchers.IO }
}