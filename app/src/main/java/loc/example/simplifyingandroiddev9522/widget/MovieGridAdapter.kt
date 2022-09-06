package loc.example.simplifyingandroiddev9522.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import loc.example.simplifyingandroiddev9522.R
import loc.example.simplifyingandroiddev9522.databinding.ListItemMovieBinding
import loc.example.simplifyingandroiddev9522.model.Movie

class MovieGridAdapter : ListAdapter<Movie, MovieViewHolder>(object :
    DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem.equals(newItem)
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return ListItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .run { MovieViewHolder(this) }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class MovieViewHolder(private val binding: ListItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) {
        binding.moviePoster.load(item.posterUrl) {
            placeholder(R.drawable.placeholder)
        }
        binding.movieTitle.text = item.title
    }
}