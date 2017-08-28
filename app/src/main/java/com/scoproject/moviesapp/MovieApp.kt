package com.scoproject.moviesapp

import android.app.Application
import android.support.multidex.MultiDex
import com.scoproject.moviesapp.di.component.AppComponent
import com.scoproject.moviesapp.di.component.DaggerAppComponent
import com.scoproject.moviesapp.di.module.AppModule
import com.scoproject.moviesapp.di.module.NetworkModule
import io.realm.Realm


@Suppress("DEPRECATION")
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
        Realm.init(this)
        MultiDex.install(this)
    }

    fun createComponent(): AppComponent {
        val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
        return appComponent
    }
}
