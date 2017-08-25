package com.scoproject.moviesapp.di.component

import com.scoproject.moviesapp.di.module.AppModule
import com.scoproject.moviesapp.di.module.NetworkModule
import com.scoproject.moviesapp.ui.activity.home.MovieComponent
import com.scoproject.moviesapp.ui.activity.home.MovieModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
@Singleton
@Component(
    modules = arrayOf(
            AppModule::class, NetworkModule::class)
)
interface AppComponent{
    fun plus(movieModule: MovieModule): MovieComponent
}
