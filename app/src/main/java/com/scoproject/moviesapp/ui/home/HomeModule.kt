package com.scoproject.moviesapp.ui.home

import com.scoproject.moviesapp.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
@Module
class HomeModule(val homeActivity: HomeActivity){

    @Provides
    @ActivityScope
    internal fun provideHomeActivity(): HomeActivity {
        return homeActivity
    }

    @Provides
    @ActivityScope
    internal fun provideMainPresenter(): HomePresenter {
        return HomePresenter()
    }

}
