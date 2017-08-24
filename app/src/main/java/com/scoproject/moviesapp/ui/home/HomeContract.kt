package com.scoproject.moviesapp.ui.home

import com.scoproject.moviesapp.data.Movie


/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

class HomeContract {

    interface View{
        fun showSnackBar(msg: String, view :android.view.View)
        fun setAdapter(movie:List<Movie>)
    }

    internal interface UserActionListener{
        fun getMovieData()
    }
}
