package com.scoproject.moviesapp.ui.home

import android.util.Log

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
class HomePresenter : HomeContract.UserActionListener {
    var mView: HomeContract.View? = null

    init {
       Log.d("HomePresenter", "hello")
    }

    fun setView(view: HomeContract.View) {
        mView = view
    }

}