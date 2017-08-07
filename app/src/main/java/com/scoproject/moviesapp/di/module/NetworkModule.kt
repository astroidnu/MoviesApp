package com.scoproject.moviesapp.di.module

import com.scoproject.moviesapp.MovieApp
import com.scoproject.moviesapp.api.NetworkService
import com.scoproject.moviesapp.utils.Constants
import com.scoproject.moviesapp.utils.CustomCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit







/**
 * Created by ibnumuzzakkir on 8/2/17.
 */
@Module
class NetworkModule(val movieApp: MovieApp){

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val httpCacheDirectory = File(movieApp.cacheDir, "httpCache")
        val cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return  OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor { chain ->
                    try {
                         chain.proceed(chain.request())
                    } catch (e: Exception) {
                        val offlineRequest = chain.request().newBuilder()
                                .header("Cache-Control", "public, only-if-cached," +
                                        "max-stale=" + 60 * 60 * 24)
                                .build()
                        chain.proceed(offlineRequest);
                    }
                }
                .cache(cache)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(CustomCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
        return builder.build()
    }


    @Provides
    @Singleton
    fun provideMovieService(restAdapter: Retrofit): NetworkService {
        return restAdapter.create<NetworkService>(NetworkService::class.java)
    }

}