package com.scoproject.moviesapp.ui.home

import com.scoproject.moviesapp.di.scope.ActivityScope

import dagger.Subcomponent

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

@ActivityScope
@Subcomponent(
        modules = arrayOf(HomeModule::class)
)
interface  HomeComponent{
    fun inject(homeActivity: HomeActivity)
}
