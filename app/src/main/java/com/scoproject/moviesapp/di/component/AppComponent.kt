package com.scoproject.moviesapp.di.component

import android.app.Application
import com.scoproject.moviesapp.di.module.AppModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by ibnumuzzakkir on 7/2/17.
 */
@Singleton
@Component(
    modules = arrayOf(AppModule::class)
)
interface AppComponent{
    companion object Factory {
        fun create(app: Application): AppComponent {
            val appComponent = DaggerAppComponent.builder().
                    appModule(AppModule(app)).
                    build()
            return appComponent
        }
    }
}
