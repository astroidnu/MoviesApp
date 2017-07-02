package com.scoproject.moviesapp.ui

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

class HomeContract {

    interface View{
        fun showSnackBar(msg: String, view :android.view.View)
    }

    internal interface UserActionListener{

    }
}
