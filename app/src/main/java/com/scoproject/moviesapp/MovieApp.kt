package com.scoproject.moviesapp

import android.app.Application
import com.scoproject.moviesapp.di.component.AppComponent
import com.scoproject.moviesapp.di.component.DaggerAppComponent
import com.scoproject.moviesapp.di.module.AppModule
import com.scoproject.moviesapp.di.module.NetworkModule


/**
 * Created by ibnumuzzakkir on 7/2/17.
 */

class MovieApp : Application() {
    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
        @JvmStatic lateinit var instance:MovieApp;
    }


    override fun onCreate() {
        super.onCreate()
        appComponent = createComponent()
        instance = this
    }

    fun createComponent(): AppComponent {
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
        return appComponent
    }
}
