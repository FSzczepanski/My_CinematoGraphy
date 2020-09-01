package com.example.mycinematography.data

class MovieRepository private constructor(private val movieDao:FakeMovieDao) {

    fun addMovie(movie: Movie){
        movieDao.addMovie(movie)
    }

    fun getMovies() = movieDao.getMovies()

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(movieDao: FakeMovieDao) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(movieDao).also {
                    instance = it
                }
            }
    }
}