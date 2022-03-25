package com.example.moviesdb01.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb01.databinding.ListItemBinding
import com.example.moviesdb01.domain.model.MoviesResult
import com.example.moviesdb01.utils.POSTER_BASE_URL
import com.squareup.picasso.Picasso

class MoviesAdapter (private var list: MutableList<MoviesResult> = mutableListOf()):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(movies: MoviesResult){
            binding.releaseDate.text = movies.releaseDate
            binding.movieName.text = movies.title
            Picasso.get().load(POSTER_BASE_URL + movies.posterPath).into(binding.movieImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = list[position]
        holder.onBind(movies)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: MutableList<MoviesResult>){
        this.list.removeAll(list)
        if (newList != null){
            this.list = newList
        }
        notifyDataSetChanged()
    }

}