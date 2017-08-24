package com.scoproject.moviesapp.ui.home

import android.util.Log
import com.scoproject.moviesapp.repository.MovieRepository

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
class HomePresenter(movieRepository: MovieRepository) : HomeContract.UserActionListener {
    val mMovieRepository = movieRepository

    var mView: HomeContract.View? = null

    fun setView(view: HomeContract.View) {
        mView = view
    }

    override fun getMovieData(){
        mView?.showLoadingbar()
        mMovieRepository.getMovies("popular")?.subscribe(
                { result -> mView?.setAdapter(result.data!!) },
                { error ->  Log.e(javaClass.name,error.message) }
            )
    }

}
