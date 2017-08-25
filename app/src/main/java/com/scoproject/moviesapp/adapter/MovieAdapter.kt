package com.scoproject.moviesapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.scoproject.moviesapp.R
import com.scoproject.moviesapp.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by ibnumuzzakkir on 8/23/17.
 */
class MovieAdapter(var movieList:List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    lateinit var movie:Movie
    lateinit var mContext : Context
    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        movie = movieList.get(position)
        holder!!.bindData(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        mContext = parent!!.context
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(movie:Movie) {
            itemView.movie_title.text = movie.title
            itemView.onClick {
                Toast.makeText(itemView.context,movie.title,Toast.LENGTH_SHORT).show()
            }
        }
    }

}