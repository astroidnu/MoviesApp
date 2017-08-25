package com.scoproject.moviesapp.ui.activity.home

import android.util.Log
import com.scoproject.moviesapp.repository.MovieRepository

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
class MoviePresenter(movieRepository: MovieRepository) : MovieContract.UserActionListener {
    val mMovieRepository = movieRepository

    var mView: MovieContract.View? = null

    fun setView(view: MovieContract.View) {
        mView = view
    }

    override fun getMovieData(){
        mView?.setLoadingBar(true)
        mMovieRepository.getMovies("popular")?.subscribe(
                { result -> mView?.setAdapter(result.data!!) },
                { error ->  Log.e(javaClass.name,error.message) }
            )
    }

}
