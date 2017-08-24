package com.scoproject.moviesapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scoproject.moviesapp.R
import com.scoproject.moviesapp.data.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by ibnumuzzakkir on 8/23/17.
 */
class MovieAdapter(var movieList:List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    lateinit var movie:Movie
    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        movie = movieList.get(position)
        holder!!.bindData(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(movie:Movie) {
            itemView.movie_title.text = movie.title
        }
    }

}