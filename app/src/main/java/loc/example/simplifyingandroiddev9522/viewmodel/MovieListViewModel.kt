package loc.example.simplifyingandroiddev9522.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import loc.example.simplifyingandroiddev9522.model.Movie
import loc.example.simplifyingandroiddev9522.repo.MovieRepo

class MovieListViewModel(private val movieRepo: MovieRepo) : ViewModel() {
    private val moviesLiveData = MutableLiveData<List<Movie>>()

    init {
        viewModelScope.launch {
            moviesLiveData.value = movieRepo.fetchMovies()
        }
    }

    fun getMoviesLiveData(): LiveData<List<Movie>> = moviesLiveData
}