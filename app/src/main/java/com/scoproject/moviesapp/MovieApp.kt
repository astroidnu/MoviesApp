package com.scoproject.moviesapp

import android.app.Application
import com.scoproject.moviesapp.di.component.AppComponent

/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

class MovieApp : Application() {
    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(this);
    }
}
