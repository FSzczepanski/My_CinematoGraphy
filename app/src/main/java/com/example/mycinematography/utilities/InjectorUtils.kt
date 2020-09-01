package com.example.mycinematography.utilities

import com.example.mycinematography.data.FakeDatabase
import com.example.mycinematography.data.MovieRepository
import com.example.mycinematography.ui.MoviesViewModelFactory

object InjectorUtils {

    fun provideMoviesViewModelFactory(): MoviesViewModelFactory {
        val movieRepository = MovieRepository.getInstance(FakeDatabase.getInstance().movieDao)
        return MoviesViewModelFactory(movieRepository)
    }
}