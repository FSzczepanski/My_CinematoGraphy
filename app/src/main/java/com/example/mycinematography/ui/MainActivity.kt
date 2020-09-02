package com.example.mycinematography.ui

import android.content.Intent
import android.content.Intent.EXTRA_COMPONENT_NAME
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mycinematography.R
import com.example.mycinematography.data.Movie
import com.example.mycinematography.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AdapterView.OnItemClickListener{

    private var arrayList:ArrayList<com.example.mycinematography.data.Movie> ? =null
    private var gridView:GridView ? = null
    private var gridAdapter:GridViewAdapter ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }


    private fun initializeUi(){
        val factory = InjectorUtils.provideMoviesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
               .get(MoviesViewModel::class.java)
        var addMovieFragment : AddMovieFragment = AddMovieFragment()

        gridView = findViewById(R.id.gridView)

        arrayList = ArrayList()

        viewModel.getMovies().observe(this, Observer { movies ->

            movies.forEach { movie ->
                arrayList!!.add(movie)
            }


        })


        gridAdapter = GridViewAdapter(applicationContext, arrayList!!)
        gridView?.adapter = gridAdapter
        gridView?.onItemClickListener = this
        arrayList!!.clear()

        buton_add_movie.setOnClickListener{

            supportFragmentManager.beginTransaction().addToBackStack(null).add(R.id.container,
                addMovieFragment
            ).commit()


        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items : Movie? = arrayList?.get(position)
        var movieInfoFragment : MovieInfoFragment = MovieInfoFragment()

        //Toast.makeText(applicationContext, "xd", Toast.LENGTH_LONG).show()

        supportFragmentManager.beginTransaction().addToBackStack(null).add(R.id.container,
            movieInfoFragment).commit()
    }

}
