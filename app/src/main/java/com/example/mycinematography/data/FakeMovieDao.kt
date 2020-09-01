package com.example.mycinematography.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeMovieDao {
    private val moviesList = mutableListOf<Movie>()
    private val movies = MutableLiveData<List<Movie>>()

    init {
        movies.value = moviesList
    }

    fun addMovie(movie: Movie){
        moviesList.add(movie)
        movies.value = moviesList
    }

    fun getMovies() = movies as LiveData<List<Movie>>
}