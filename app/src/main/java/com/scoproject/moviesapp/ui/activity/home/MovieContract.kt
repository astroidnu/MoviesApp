package com.scoproject.moviesapp.ui.activity.home

import com.scoproject.moviesapp.data.Movie


/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

class MovieContract {

    interface View{
        fun setupLayout()
        fun setLoadingBar(status : Boolean)
        fun showSnackBar(msg: String, view :android.view.View)
        fun setAdapter(movie:List<Movie>)
    }

    internal interface UserActionListener{
        fun getMovieData()
    }
}
