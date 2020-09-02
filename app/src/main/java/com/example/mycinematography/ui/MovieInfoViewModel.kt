package com.example.mycinematography.ui

import androidx.lifecycle.ViewModel
import com.example.mycinematography.data.Movie
import com.example.mycinematography.data.MovieRepository

class MovieInfoViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies() = movieRepository.getMovies()

    fun addMovies(movie: Movie) = movieRepository.addMovie(movie)
    fun removeMovies(movie: Movie) = movieRepository.removeMovie(movie)
}
