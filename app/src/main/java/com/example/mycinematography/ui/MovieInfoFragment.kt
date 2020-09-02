package com.example.mycinematography.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer

import com.example.mycinematography.R
import com.example.mycinematography.data.Movie
import com.example.mycinematography.utilities.InjectorUtils
import kotlin.random.Random

class MovieInfoFragment : Fragment() {

    companion object {
        fun newInstance() = MovieInfoFragment()
    }

    private lateinit var viewModel: MovieInfoViewModel
    private var arrayList:ArrayList<com.example.mycinematography.data.Movie> ? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    fun initial(view: View){


        var icons: ImageView = view.findViewById(R.id.icons)
        var names: TextView = view.findViewById(R.id.names)
        var directors:TextView = view.findViewById(R.id.directors)
        var notes:TextView = view.findViewById(R.id.notes)
        var grades: TextView = view.findViewById(R.id.grades)


        val args = arguments
        val itemData = args?.getString("itemData","")

        var list= emptyArray<String>()
        if (itemData != null) {
            list = itemData.split("-").toTypedArray()
        }

        val imgList=arrayListOf(R.drawable.i1,R.drawable.i2,R.drawable.i3
            ,R.drawable.i4,R.drawable.i5)

        val r = Random.nextInt(0,4)

        icons.setImageResource(imgList[r])
        names.text = list.get(0)
        directors.text = list.get(2)
        notes.text = list.get(1)
        grades.text = list.get(3)
    }
}
