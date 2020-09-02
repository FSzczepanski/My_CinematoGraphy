package com.example.mycinematography.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mycinematography.R
import com.example.mycinematography.data.Movie
import kotlin.random.Random

class GridViewAdapter(var context: Context, var arrayList: ArrayList<Movie>)
    : BaseAdapter(){

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View = View.inflate(context, R.layout.card_view_item_grid,null)
        var icons:ImageView = view.findViewById(R.id.icons)
        var names:TextView = view.findViewById(R.id.names)
      //  var directors:TextView = view.findViewById(R.id.directors)
       // var notes:TextView = view.findViewById(R.id.notes)
        var grades:TextView = view.findViewById(R.id.grades)

        var listItem:Movie = arrayList.get(position)

        val list=arrayListOf(R.drawable.i1,R.drawable.i2,R.drawable.i3
        ,R.drawable.i4,R.drawable.i5)

        val r = Random.nextInt(0,4)

        icons.setImageResource(list[r])
        names.text = listItem.name
    //    directors.text = listItem.director
     //   notes.text = listItem.note
        grades.text = listItem.grade

        return view
    }
}