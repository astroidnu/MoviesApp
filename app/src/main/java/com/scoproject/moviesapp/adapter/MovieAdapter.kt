package com.scoproject.moviesapp.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.scoproject.moviesapp.R
import com.scoproject.moviesapp.data.Movie
import com.scoproject.moviesapp.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by ibnumuzzakkir on 8/23/17.
 */
class MovieAdapter(var movieModelList:List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    lateinit var movieModel: Movie
    lateinit var mContext : Context
    override fun getItemCount(): Int {
        return movieModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        movieModel = movieModelList.get(position)
        holder!!.bindData(movieModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        mContext = parent!!.context
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(movieModel: Movie) {
            Picasso.with(itemView.context)
                    .load(Uri.parse(Constants.BASE_URL_IMAGE+movieModel.posterPath))
                    .into(itemView.movie_image)
            itemView.movie_title.text = movieModel.title
            itemView.movie_year.text = movieModel.releaseDate
            itemView.onClick {
                Toast.makeText(itemView.context, movieModel.title,Toast.LENGTH_SHORT).show()
            }
        }
    }

}