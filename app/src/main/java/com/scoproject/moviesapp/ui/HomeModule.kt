package com.scoproject.moviesapp.ui

import com.scoproject.moviesapp.di.scope.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Inject

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
