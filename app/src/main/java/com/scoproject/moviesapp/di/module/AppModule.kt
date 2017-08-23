package com.scoproject.moviesapp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
@Module
class AppModule(val application: Application){
    @Singleton
    @Provides
    internal fun provideContext(): Context {
        return application
    }
}
