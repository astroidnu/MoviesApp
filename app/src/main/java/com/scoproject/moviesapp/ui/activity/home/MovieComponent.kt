package com.scoproject.moviesapp.ui.activity.home

import com.scoproject.moviesapp.di.scope.ActivityScope

import dagger.Subcomponent

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

@ActivityScope
@Subcomponent(
        modules = arrayOf(MovieModule::class)
)
interface MovieComponent {
    fun inject(movieActivity: MovieActivity)
}
