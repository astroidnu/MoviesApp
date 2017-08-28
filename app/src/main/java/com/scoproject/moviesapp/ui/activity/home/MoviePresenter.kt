package com.scoproject.moviesapp.ui.activity.home


import com.scoproject.moviesapp.api.NetworkError
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
        mMovieRepository.getMovies("popular")
                ?.subscribe({
                    data->
                    mView?.setLoadingBar(false)
                    mView?.setAdapter(data.results!!)
                },{
                    error->
                    mView?.setLoadingBar(false)
                    val errMsg = NetworkError(error).getErrorMessage()
                    mView?.showToast(errMsg)
                })
    }

//    fun handlingError(error:Throwable){
//        mView?.setLoadingBar(false)
//        if (error is retrofit2.HttpException) {
//            val exception   = error
//            mView?.showToast(exception.code().toString())
//        }
//    }

}