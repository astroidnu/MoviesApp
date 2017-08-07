package com.scoproject.moviesapp.api

import com.scoproject.moviesapp.data.Movie
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ibnumuzzakkir on 8/2/17.
 */
interface NetworkService{
    @GET("movie/{sort}")
    fun getMoviesData(@Query("api_key") api_key : String, @Path("sort") sort: String) : Flowable<ApiResponse<BaseApiResponse<Movie>>>
}