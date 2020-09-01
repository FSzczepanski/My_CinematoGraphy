package com.example.mycinematography.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycinematography.data.MovieRepository

class MoviesViewModelFactory(private val movieRepository: MovieRepository)
    : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(movieRepository) as T
    }
}