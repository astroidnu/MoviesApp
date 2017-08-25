package com.scoproject.moviesapp.ui.activity.home

import com.scoproject.moviesapp.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import com.scoproject.moviesapp.repository.MovieRepository
import com.scoproject.moviesapp.api.NetworkService




/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
@Module
class MovieModule(val movieActivity: MovieActivity){

    @Provides
    @ActivityScope
    internal fun provideHomeActivity(): MovieActivity {
        return movieActivity
    }

    @Provides
    @ActivityScope
    fun provideMovieRepository(networkService: NetworkService): MovieRepository {
        return MovieRepository(networkService)
    }
    @Provides
    @ActivityScope
    fun provideMainPresenter(movieRepository: MovieRepository): MoviePresenter {
        return MoviePresenter(movieRepository)
    }
}
