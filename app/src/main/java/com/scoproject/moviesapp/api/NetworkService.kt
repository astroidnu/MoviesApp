package com.scoproject.moviesapp.api

import com.scoproject.moviesapp.data.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ibnumuzzakkir on 8/2/17.
 */
interface NetworkService{
    @GET("movie/{sort}")
    fun getMoviesData(@Path("sort") sort: String,@Query("api_key") api_key : String) : Flowable<ApiResponse<BaseApiResponse<List<Movie>>>>
}