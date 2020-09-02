package com.example.mycinematography.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mycinematography.R
import com.example.mycinematography.utilities.InjectorUtils

class MovieInfoFragment : Fragment() {

    companion object {
        fun newInstance() = MovieInfoFragment()
    }

    private lateinit var viewModel: MovieInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = InjectorUtils.provideMoviesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(MoviesViewModel::class.java)
        initial()
    }

    fun initial(){

    }
}
