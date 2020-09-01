package com.example.mycinematography.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mycinematography.R
import com.example.mycinematography.data.Movie
import com.example.mycinematography.utilities.InjectorUtils
import kotlinx.android.synthetic.main.fragment_add_movie.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddMovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            AddMovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun initialize(){
        val factory = InjectorUtils.provideMoviesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(MoviesViewModel::class.java)

        //viewModel.getMovies().observe(this, Observer { movies ->
//            textView_movies.text = stringBuilder.toString()
       // })
            buttonAdd.setOnClickListener {

                val movie = Movie(addName.text.toString(), addDirector.text.toString(),
                    addNote.text.toString(),addGrade.text.toString())
                viewModel.addMovies(movie)
                getActivity()?.onBackPressed()

    }
}
}

